import os
import core

fn main() {
	args := os.args[1..]
	word := args[0] 

	res := core.run(word)

	println(res)
}