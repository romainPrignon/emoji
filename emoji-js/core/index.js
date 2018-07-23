const got = require('got')
const { maxBy, get } = require('lodash/fp')


class EmojiNotFoundError extends Error {
    constructor(message) {
        super(message)
        this.name = this.constructor.name

        this.code = 'EmojiNotFoundError'
    }
}

const doQuery = async (word) =>
{
    try {
        return got(
            'emoji.getdango.com/api/emoji',
            {
    		    json: true,
    		    query: {
    			    q: word
    		    }
    	    }
        )
    } catch (err) {
        throw new EmojiNotFoundError('EmojiNotFoundError') // throw (generic/specific) or return
    }

}

const filterBestEmoji = (response) =>
{
    const { results } = response.body

    return get('text', maxBy(r => r.score)(results))
}

const emoji = (query = doQuery) => async (word) =>
{
    // because we are not in a stricly typed langage
    if (!word) {
        throw new Error('UndefinedWordError')
    }

    const response = await query(word)

    return filterBestEmoji(response)
}

module.exports = {
    emoji,
    EmojiNotFoundError
}

// WHAT CAN BE DONE
// better error handling => return error instead of throw
