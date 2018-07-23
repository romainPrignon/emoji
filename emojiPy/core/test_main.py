import unittest

import main

# mock
from requests import ConnectionError

class TestMain(unittest.TestCase):

    def test_Emoji(self):
        # given
        word = 'love'
        # mock
        def do_query(word):
            return {
                'results': [
                    {
	                    "text": '❤️',
	                    "score": '0.99'
	                },
	                {
	                    "text": '😒',
	                "score": '0.01'
	                }
                ]
            }

        # when
        e = main.Emoji(do_query)
        output = e.emoji(word)

        # then
        self.assertEqual(output, '❤️')

# Or test can be done this way

class EmojiFailureTestCase(unittest.TestCase):

    def runTest(self):
        # given
        word = 'love'
        # mock
        def do_query(word):
            raise ConnectionError('boom') # seems that it's not lazy

        # when
        e = main.Emoji(do_query)

        # then
        try:
            output = e.emoji(word)

            self.fail('should fail')
        except ConnectionError as e:
            pass
            # self.assertEquals(e, ConnectionError('boom')) # should pass

if __name__ == '__main__':
    unittest.main()