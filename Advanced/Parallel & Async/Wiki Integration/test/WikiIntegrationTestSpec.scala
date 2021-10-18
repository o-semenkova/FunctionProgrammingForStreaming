import WikiIntegrationTask.retrieveLatestChanges
import org.scalatest.funsuite.AnyFunSuite

import java.time.LocalDateTime
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

class WikiIntegrationTestSpec extends AnyFunSuite {
  test("First test") {
    val wikiChanges = Await.result(retrieveLatestChanges(), 10 seconds)

    assert(wikiChanges.nonEmpty, "List of WikiChanges should have values")
    wikiChanges.foreach(wc => {
      assert(!wc.title.isBlank, "WikiChange[title] should be enriched with data")
      assert(!wc.link.isEmpty, "WikiChange[link] should be enriched with data")
      assert(!wc.guid.isEmpty, "WikiChange[guid] should be enriched with data")
      assert(!wc.description.isBlank, "WikiChange[description] should be enriched with data")
      assert(wc.pubDate.isBefore(LocalDateTime.now()), "WikiChange[pubDate] should be enriched with data")
    })
  }
}
