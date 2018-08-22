package core

import scalaj.http.{HttpResponse, HttpOptions, Http}
//import argonaut.{Parse, Json, CodecJson}
import argonaut._, Argonaut._

object Main {
  case class Result(score: Float, text: String)
  case class Results(results: List[Result])

  implicit def ResultsCodecJson: CodecJson[Results] =
    casecodec1(Results.apply, Results.unapply)("results")

  implicit def ResultCodecJson: CodecJson[Result] =
    casecodec2(Result.apply, Result.unapply)("score", "text")

  def doQuery(word: String): HttpResponse[String] = {
    val url = "http://emoji.getdango.com/api/emoji"
    val response = Http(url)
      .param("q", word)
      .option(HttpOptions.followRedirects(true))

    return response.asString
  }

  def filterBestEmoji(response: HttpResponse[String]): Either[Exception, String] = {
    val result = Parse.decodeEither[Results](response.body)
      
    return result match {
      case Left(err) => {
        println(err)
        return Left(new Exception("JsonParseError"))
      }
      case Right(res) => {
        val maxByScore: (Result) => Float = (result) => result.score
        
        val maxRes = res.results.maxBy(maxByScore)

        return Right(maxRes.text)
      }
    }
  }
  
  def emoji(word: String): Either[Exception, Either[Exception, String]] = {
    if (word.isEmpty()) {
      return Left(new Exception("UndefinedWordError"))
    }

    return Right(filterBestEmoji(doQuery(word)))
  }
}
