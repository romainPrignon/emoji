package main

import (
	"github.com/romainprignon/emoji/core"
	"log"
	"os"
)

// void => string
func Stdin() string {
	arg := os.Args[1] // parameter are not optional

	return arg
}

// string => string
func Cli(word string) string {
	if word == "--help" {
		return Instruction()
	}

	return core.Emoji(word)
}

//string => void
func Stdout(output string) {
	log.Println(output)
}

func Instruction() string {
	return `
    === Emoji ===

> Find an emoji given a word...

# Command
emoji --help        It will print this
emoji [word]        It will fetch an emoji for your word
`
}

func main() {
	Stdout(Cli(Stdin()))
}
