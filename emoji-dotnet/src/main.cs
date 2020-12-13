using System;
using System.Net.Http;
using System.Threading.Tasks;
using Core;

public static class Program
{
    public static async Task Main(string[] args) 
    {
        HttpClient httpClient = new HttpClient();
        Engine engine = new Engine(httpClient);

        string res = await engine.run(args[0]);
        Console.WriteLine(res);
    }
}