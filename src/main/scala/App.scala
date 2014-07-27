package io.flatmap

import io.flatmap.models.Bookmark

/** The launched conscript entry point */
class App extends xsbti.AppMain {
  def run(config: xsbti.AppConfiguration) = {
    Exit(App.run(config.arguments))
  }
}

object App {
  /** Shared by the launched version and the runnable version,
   * returns the process status code */
  def run(args: Array[String]): Int = {
    if ("find".equals(args(0)))
      BookmarkComponentRegistry.service.find(args(1)).foreach { bookmark =>
        println(s"${Console.BLUE}${Console.YELLOW_B}${Console.UNDERLINED}${bookmark.url}${Console.RESET} ${bookmark.comment}")
      }
    else
      BookmarkComponentRegistry.service.write(Bookmark(args(0), args(1)))
    0
  }
  /** Standard runnable class entrypoint */
  def main(args: Array[String]) {
    System.exit(run(args))
  }
}

case class Exit(val code: Int) extends xsbti.Exit
