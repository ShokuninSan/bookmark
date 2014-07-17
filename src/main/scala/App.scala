package io.flatmap

import io.flatmap.components.{ServiceComponentImpl, MongoDaoComponentImpl}
import io.flatmap.models.Bookmark

/** The launched conscript entry point */
class App extends xsbti.AppMain {
  def run(config: xsbti.AppConfiguration) = {
    Exit(App.run(config.arguments))
  }
}

object BookmarkComponentRegistry extends ServiceComponentImpl with MongoDaoComponentImpl {

  val mongoServer = "flatmap.io"
  val mongoPort = 27017
  val mongoDb = "bookmark"
  val mongoCollection = "shokunin"

  val service = new ServiceImpl
  val dao = new MongoDaoImpl

}

object App {
  /** Shared by the launched version and the runnable version,
   * returns the process status code */
  def run(args: Array[String]): Int = {
    BookmarkComponentRegistry.service.write(Bookmark(args(0), args(1)))
    0
  }
  /** Standard runnable class entrypoint */
  def main(args: Array[String]) {
    System.exit(run(args))
  }
}

case class Exit(val code: Int) extends xsbti.Exit
