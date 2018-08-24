package cli

import scala.io.StdIn.{readLine}
import core.Main.emoji

object Main extends App {
    def stdin(): String = {
        readLine()
    }
    def cli(word: String): Either[Exception, Either[Exception, String]] = {
        emoji(word)
    }
    def stdout(output: String): Unit = {
        println(output)
    }

    val res = cli(stdin())
    
    res.fold(
        l => "Please give a word",
        r => r.fold(
            l => "There was an error",
            r => r
        )
    )
}
