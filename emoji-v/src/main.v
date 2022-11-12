import os
import core

fn stdin(argv []string) !string {
	args := argv[1..]
	word := args[0]!

	return word
}

fn stdout(res string) {
	println(res)
}

fn main() {
	word := stdin(os.args) or {panic("Give some word as input")} // could also just print

	// res := core.run(word)! // will panic
	res := core.run(word) or {"Something Broke !"}

	stdout(res)
}