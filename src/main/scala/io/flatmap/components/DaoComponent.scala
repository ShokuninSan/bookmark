package io.flatmap.components

import io.flatmap.models.Bookmark
import scala.pickling._
import json._
import scala.reflect.io.{Path, File, Directory}

trait DaoComponent {

  trait Dao {

    def write(bookmark: Bookmark): Unit

  }

}

trait DaoComponentImpl extends DaoComponent {

  class DaoImpl extends Dao {

    def write(bookmark: Bookmark): Unit = {
      val home = System.getenv("HOME")
      val filename = System.currentTimeMillis().toString
      val path = Path(s"$home/.bookmark/$filename")
      val file = path.createFile()
      file.writeAll(bookmark.pickle.toString)
    }

  }

}
