import gleam/io
import core
import argv
import gleam/int

pub fn main() {
  case argv.load().arguments {
    [text] -> io.println(int.to_string(core.run(text))) // todo: pipeline operator ? compose ?
    _ -> io.println("give an emoji text")
  }
}