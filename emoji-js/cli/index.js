#!/usr/bin/env node

const {emoji} = require('../core')

// void => string
const stdin = async () => {
    const argv = process.argv.slice(2)

    if (argv.includes('--help')) {
        const help = true
        const word = undefined

        return {help, word}
    } else {
        const help = false
        const word = argv[0]

        return {help, word}
    }
}

// string => void
const stdout = async (output) => {
    console.log(output)
}

// string => string
const main = async ({word, help}) => {
    const client = emoji()

    if (help || !word) {
        return await instruction()
    }

    try {
        return await client(word)
    } catch (err) {
        switch (err.message) {
            case 'EmojiNotFoundError': {
                return '✘ Sorry, there is not emoji for you'
            }
            case 'UndefinedWordError': {
                return '✘ you have to define a word'
            }
            default: {
                return 'something broke !'
            }
        }
    }

}

const instruction = async () => `
    \x1b[1m\x1b[32m === Emoji === \x1b[0m

    > Find an emoji given a word...

    \x1b[1m\x1b[32m # Command \x1b[0m
    emoji --help        It will print this
    emoji [word]        It will fetch an emoji for your word
`


const cli = async () =>
    stdin()
        .then(main)
        .then(stdout)

require.main === module
    ? cli()
    : process.exit(1)

// WHAT CAN BE DONE
// better error handling : return error instead of trhow
// use streams