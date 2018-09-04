# WTF ! Can't import .. as module without that ?
import sys
sys.path.append('../')


import argparse
from core.main import Emoji


def stdin():
    parser = argparse.ArgumentParser(description='Find an emoji given a word')
    parser.add_argument('word', metavar='word', type=str, help='a word to find an emoji for')

    args = parser.parse_args()

    return args.word

def main(word):
    e = Emoji()

    try:
        res = e.emoji(word)

        return res
    except ValueError as e:
        if str(e) == 'undefined_word_foo_error': print('There is no emoji for foo') # specific catch
        else: print('There is no emoji for that word') # generic catch

        sys.exit(1)

def stdout(output):
    print(output)

def cli():
    stdout(main(stdin()))


if __name__ == '__main__':
    cli()
