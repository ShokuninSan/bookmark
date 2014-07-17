package io.flatmap

import scala.io.Source

trait ConfigComponent {

  lazy val Config: Map[String, String] = initConfig

  private def initConfig: Map[String, String] = {
    val home = System.getenv("HOME")
    val lines = Source.fromFile(s"$home/.bookmarkrc").getLines
    val cfg = collection.mutable.Map[String, String]()

    val liste: List[(String, String)] = lines.map { l =>
      val list = l.split("=")
      (list(0).trim, list(1).trim)
    }.toList

    for {
      pair <- liste
    } yield cfg += pair

    cfg.toMap
  }

}
