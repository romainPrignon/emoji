import sys
sys.path.append('../')

import unittest

# test
from src.core.main import Core

# mock
from requests import ConnectionError

class Res:
    def json(): 
        return {
            "results": [
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

class TestCore(unittest.TestCase):
    def test_run(self):
        # given
        word = 'love'
        
        # mock
        class Requests:
            def get(url, params):
                return Res

        # when
        core = Core(Requests)
        output = core.run(word)

        # then
        self.assertEqual(output, '❤️')


class TestCoreWithNetworkFailure(unittest.TestCase):
    def test_run(self):
        # given
        word = 'love'
        
        # mock
        class Requests:
            def get(url, params):
                raise ConnectionError('boom')

        # when
        core = Core(Requests)
        
        # then
        try:
            output = core.run(word)

            self.fail('should fail')
        except ConnectionError as e:
            self.assertEqual(str(e), 'boom')


if __name__ == '__main__':
    unittest.main()