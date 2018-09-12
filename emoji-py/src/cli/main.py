import argparse
import requests
import sys
from core.main import Core


def stdin():
    parser = argparse.ArgumentParser(description="Find an emoji given a word")
    parser.add_argument("word", metavar="word", type=str, help="a word to find an emoji for")

    args = parser.parse_args()

    return args.word

def main(word):
    core = Core(requests)

    try:
        res = core.run(word)

        return res
    except Exception as e:
        if str(e) == "undefined_word_error": print("There is no emoji for foo")
        else: print("[Something broke !]", e)

        sys.exit(1)

def stdout(output):
    print(output)

def cli():
    stdout(main(stdin()))
