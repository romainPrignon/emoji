import requests
from argparse import Namespace


def Core(http_client):
    
    def do_query(word):
        access_key = "c19560f67ed78510d1fa453f5609665c9538934d"
        return http_client.get("https://emoji-api.com/emojis", params = {"search": word, "access_key": access_key})


    def parse_json(res):
        # return res.json()["results"]
        return res.json()[0]


    def filter_best_emoji(res):
        # maxEmoji = max(results, key = lambda r: r["score"])

        return res["character"]


    def run(word):
        if not word: raise ValueError("undefined_word_error")
        
        return filter_best_emoji(parse_json(do_query(word)))


    return Namespace(
        run=run
    )
