from argparse import Namespace
from typing import Callable, List


import requests

# type hinting: python 3.6
Response = List
Query = Callable[[str], Response]


def Emoji(http_client = None):

    def query(word):
        payload = {'q': word}

        resp = requests.get('http://emoji.getdango.com/api/emoji', params = payload)

        return resp.json()

    def filter_best_emoji(response):
        res = response['results']

        maxEmoji = max(res, key = lambda r: r['score'])

        return maxEmoji['text']

    def emoji(word: str) -> str : # type hinting
        if word == 'foo' : raise ValueError('undefined_word_foo_error') # just a test to see how to handle error

        if http_client == None:
            do_query = query
        else:
            do_query = http_client

        response = do_query(word)

        return filter_best_emoji(response)

    return Namespace(
        emoji=emoji
    )


# e = Emoji()
# e['emoji']('love') # closure assez moche avec un dic
# print(e.emoji('love')) # ca marche avec un namespace
