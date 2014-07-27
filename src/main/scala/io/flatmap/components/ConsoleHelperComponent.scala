package io.flatmap.components

import io.flatmap.models.Bookmark
import org.joda.time.DateTime

trait ConsoleHelperComponent {

  trait ConsoleHelper {

    def dispatch(args: Seq[String]): Unit

  }

}

trait ConsoleHelperComponentImpl extends ConsoleHelperComponent {

  this: ServiceComponent =>

  val service: Service

  class ConsoleHelperImpl extends ConsoleHelper {

    def dispatch(args: Seq[String]): Unit =
      args match {
        case Seq("import", filename: String) =>
          service.`import`(filename)
        case Seq("find", query: String) =>
          service.find(query).foreach { printResult }
        case Seq(url: String, description: String) =>
          service.write(Bookmark(url, description, Some(new DateTime), Some(new DateTime)))
        case _ =>
          println("Usage: bookmark { find <regex> | <url> <description> } ")
      }

    private def printResult(bookmark: Bookmark) = {
      print(s"${bookmark.description}: ")
      print(s"${Console.BLUE}${Console.YELLOW_B}${Console.UNDERLINED}")
      print(s"${bookmark.url}")
      print(s"${Console.RESET}")
      println(s" (added on ${bookmark.addDate.map(_.toDate)}})")
    }

  }

}