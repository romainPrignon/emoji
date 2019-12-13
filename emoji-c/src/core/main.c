#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>

#include <curl/curl.h>

struct Result {
    char text[]; // actual emoji
    int score;
};

struct Results {
  struct Result results[]; // array of emoji
  size_t size;
};

struct Data {
  char* content;
  size_t size;
};

static size_t write_emoji(void *contents, size_t size, size_t nmemb, void *userp)
{
//   printf("%p\n",contents);
//   printf("%l\n",size);
//   printf("%l\n",nmemb);
//   printf("%p\n",userp);
  
  size_t realsize = size * nmemb;
  struct Data *data = (struct Data *)userp;
 
  char* ptr = realloc(data->content, data->size + realsize + 1);
  if (ptr == NULL) {
    /* out of memory! */ 
    printf("oom\n");
    return 0;
  }
 
  data->content = ptr;
  memcpy(&(data->content[data->size]), contents, realsize);
  data->size += realsize;
  data->content[data->size] = 0;
 
  return realsize;
}

const struct Data do_query(const char word[])
{
    const char url[] = "http://emoji.getdango.com/api/emoji";
    
    struct Data data;
    data.content = malloc(1);
    data.size = 0;

    // init
    curl_global_init(CURL_GLOBAL_ALL);
    CURL* curl_handle = curl_easy_init();
    curl_easy_setopt(curl_handle, CURLOPT_URL, url);
    curl_easy_setopt(curl_handle, CURLOPT_WRITEFUNCTION, write_emoji);
    curl_easy_setopt(curl_handle, CURLOPT_WRITEDATA, (void*)&data);

    CURLcode curl_result = curl_easy_perform(curl_handle);
    
    curl_easy_cleanup(curl_handle);
    curl_global_cleanup();
    free(data.content);

    if (curl_result != CURLM_OK) {
        printf("http error");
        return NULL;
        
    } else {
        printf("%s", data->content);
        return data;
    }
}

const struct Results parse_json(const struct Data data)
{
    // parse json to actual structure
    return data->content;
}

const char* filter_best_emoji(const struct Results results) 
{
    return results[0]->text;
}

//can't return const char[] but it is the same
const char* run(const char word[])
{
    if (word == NULL) {
        return NULL;
    }

    return filter_best_emoji(parse_json(do_query(word)));
}

// this is cli
int main(int argc, const char* argv[])
{
    const char res[] = run(argv[1]);

    printf("%s", res);

    if (res == NULL) {
        exit(EXIT_FAILURE);
    } else {
        exit(EXIT_SUCCESS);
    }
}
