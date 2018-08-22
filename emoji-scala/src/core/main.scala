package core

import scalaj.http.{HttpResponse, HttpOptions, Http}
import argonaut.{Parse, Json}

case class Result(score: Float, text: String)
case class Results(results: Array[Result])

object Main {
  def doQuery(word: String): HttpResponse[String] = {
    val url = "http://emoji.getdango.com/api/emoji"
    val response = Http(url)
      .param("q", word)
      .option(HttpOptions.followRedirects(true))

    return response.asString
  }

  def filterBestEmoji(response: HttpResponse[String]): String = {
    val result: Either[String, Json] = Parse.parse(response.body) // Results type
      
    return result match {
      case Left(err) => println("there was an error: " + err)
      case Right(res) => {
        println(result)
        return res.results
      }
    }
  }
  
  def emoji(word: String): Either[Exception, String] = {
    if (!word) {
      return new Exception("UndefinedWordError")
    }

    return filterBestEmoji(doQuery(word))
  }
}
