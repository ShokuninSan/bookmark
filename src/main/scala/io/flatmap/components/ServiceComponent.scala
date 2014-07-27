package io.flatmap.components

import io.flatmap.models.Bookmark
import scala.reflect.io.Path
import scala.xml.XML
import org.htmlcleaner.HtmlCleaner
import java.io.File
import org.joda.time.DateTime

trait ServiceComponent {

  trait Service {

    def write(bookmark: Bookmark): Unit

    def find(query: String): Stream[Bookmark]

    def `import`(filename: String): Unit

  }

}

trait ServiceComponentImpl extends ServiceComponent {

  this: DaoComponent =>

  val dao: Dao

  class ServiceImpl extends Service {

    def write(bookmark: Bookmark): Unit = dao.write(bookmark)

    def find(query: String): Stream[Bookmark] = dao.find(query)

    def `import`(filename: String): Unit = {
      val now = new DateTime()
      val cleaner = new HtmlCleaner
      val props = cleaner.getProperties
      val rootNode = cleaner.clean(new File(filename))
      val elements = rootNode.getElementsByName("A", true)
      for (elem <- elements) {
        val url = elem.getAttributeByName("HREF")
        val description = elem.getText
        dao.write(Bookmark(url, description.toString, Some(now), Some(now)))
      }
    }
  }

}