package core

import scalaj.http._
import scala.util.parsing.json._

object Main {
  def doQuery(word: String): HttpResponse[String] = {
    val url = "http://emoji.getdango.com/api/emoji"
    val response: HttpResponse[String] = Http(url).param("q", word).asString

    return response
  }

  def filterBestEmoji(response: HttpResponse[String]): String = {
      val result = JSON.parseFull(response.body)
      
      result match {
        case Some(e) => {
          println(e)
          return e
        }
        case None => "failed"
      }
  }
  
  def emoji(word: String): String = filterBestEmoji(doQuery(word))
}
