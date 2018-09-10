from typing import Callable, List, Dict

import requests
from argparse import Namespace

Response = requests.models.Response
Results = List

def Core(http_client) -> Namespace:
    
    def do_query(word: str) -> Response: 
        return http_client.get("http://emoji.getdango.com/api/emoji", params = {"q": word})


    def parse_json(response: Response) -> Results: # Results must be a class
        return response.json()


    def filter_best_emoji(res: Results):
        results = res["results"]

        maxEmoji = max(results, key = lambda r: r["score"])

        return maxEmoji["text"]


    def run(word: str) -> str:
        if not word: raise ValueError("undefined_word_error")
        
        return filter_best_emoji(parse_json(do_query(word)))


    return Namespace(
        run=run
    )
