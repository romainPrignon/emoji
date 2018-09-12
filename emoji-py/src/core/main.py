import requests
from argparse import Namespace


def Core(http_client):
    
    def do_query(word):
        return http_client.get("http://emoji.getdango.com/api/emoji", params = {"q": word})


    def parse_json(res):
        return res.json()["results"]


    def filter_best_emoji(results):
        maxEmoji = max(results, key = lambda r: r["score"])

        return maxEmoji["text"]


    def run(word):
        if not word: raise ValueError("undefined_word_error")
        
        return filter_best_emoji(parse_json(do_query(word)))


    return Namespace(
        run=run
    )
