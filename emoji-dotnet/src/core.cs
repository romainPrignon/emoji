using System;
using System.Web;
using System.Net.Http;
using System.Threading.Tasks;
using System.Collections.Generic;
using System.Text.Json;

namespace Core
{
    public class Result
    {
        public string slug { get; set; }
        public string character { get; set; }
        public string unicodeName { get; set; }
        public string codePoint { get; set; }
        public string group { get; set; }
        public string subGroup { get; set; }
    }

    public class Engine 
    {
        private HttpClient httpClient;
        
        public Engine(HttpClient httpClient) {
            this.httpClient = httpClient;
        }
        
        private async Task<HttpResponseMessage> do_query(string word) 
        {
            try	
            {
                var builder = new UriBuilder("https://emoji-api.com/emojis");
                var query = HttpUtility.ParseQueryString(builder.Query);
                query["search"] = word;
                query["access_key"] = "c19560f67ed78510d1fa453f5609665c9538934d";
                builder.Query = query.ToString();
                string url = builder.ToString();

                HttpResponseMessage response = await this.httpClient.GetAsync(url);
                response.EnsureSuccessStatusCode();
                
                return response;
            }
            catch(HttpRequestException)
            {
                return null;
            }
        }

        private async Task<List<Result>> parse_json(Task<HttpResponseMessage> response) 
        {
            var res = await response;
            return JsonSerializer.Deserialize<List<Result>>(res.Content.ReadAsStringAsync().Result);
        }
        
        private async Task<string> filter_best_emoji (Task<List<Result>> results) 
        {
            var res = await results;
            return res[0].character;
        }

        public async Task<string> run (string word)
        {
            if (String.IsNullOrEmpty(word)) {
                throw new ArgumentNullException("word is empty");
            }

            return await this.filter_best_emoji(this.parse_json(this.do_query(word)));
        }
    } 
}
