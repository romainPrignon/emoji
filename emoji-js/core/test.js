import test from 'ava'

import { emoji, EmojiNotFoundError } from './index'

test('emoji: should return ❤ from word "love"', async t => {
	const word = 'love'

	// mock
	const doQuery = () => ({
	    body: {
	        results: [
	            {
	                text: '❤',
	                score: '0.99'
	            },
	            {
	                text: '😒',
	                score: '0.01'
	            }
            ]
	    }
	})

    const emojiClient = emoji(doQuery)

	const res = await emojiClient(word)

	t.is(res, '❤')
})

test('emoji: should throw an exception', async t => {
	const word = 'undefined'

    //mock
    const doQuery = () => {
        throw new EmojiNotFoundError('boom')
    }

    const emojiClient = emoji(doQuery)
	const error = await t.throws(emojiClient(word))

	t.true(error instanceof EmojiNotFoundError)
})