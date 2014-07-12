package io.flatmap

import io.flatmap.components.{ServiceComponentImpl, DaoComponentImpl}
import io.flatmap.models.Bookmark

/** The launched conscript entry point */
class App extends xsbti.AppMain {
  def run(config: xsbti.AppConfiguration) = {
    Exit(App.run(config.arguments))
  }
}

object BookmarkComponentRegistry extends ServiceComponentImpl with DaoComponentImpl {

  val service = new ServiceImpl
  val dao = new DaoImpl

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
