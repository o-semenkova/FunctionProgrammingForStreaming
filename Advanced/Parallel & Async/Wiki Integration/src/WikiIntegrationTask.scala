import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.marshallers.xml.ScalaXmlSupport._
import akka.http.scaladsl.model.Uri.Query
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.headers._
import akka.http.scaladsl.unmarshalling.Unmarshal

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.xml.NodeSeq

object WikiIntegrationTask {

  def retrieveLatestChanges(): Future[Seq[WikiChange]] = {
    implicit val system = ActorSystem(Behaviors.empty, "Single")
    implicit val executionContext = system.executionContext

    val uri =  Uri("https://www.mediawiki.org/w/api.php") withQuery("action", "feedrecentchanges") +: ("feedformat", "rss") +: Query.Empty

    Http().singleRequest(HttpRequest(
      method = HttpMethods.GET,
      uri = uri,
      headers = Accept(MediaTypes.`application/xml`) :: Nil
    ))
      .map(_.entity)
      .flatMap(Unmarshal(_).to[NodeSeq])
      .map(a => (a \ "channel" \ "item")
      .map(node => WikiChange((node \ "title").text, Uri((node \ "link").text), Uri((node \ "guid").text),
        (node \ "description").text, LocalDateTime.from(DateTimeFormatter.RFC_1123_DATE_TIME.parse((node \ "pubDate").text)))))

  }

  case class WikiChange(title: String, link: Uri, guid: Uri, description: String, pubDate: LocalDateTime)

}