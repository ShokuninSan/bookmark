package io.flatmap.components

import io.flatmap.models.Bookmark
import scala.pickling._
import json._

trait DaoComponent {

  trait Dao {

    def write(bookmark: Bookmark): Unit

  }

}

trait DaoComponentImpl extends DaoComponent {

  class DaoImpl extends Dao {

    def write(bookmark: Bookmark): Unit = println(bookmark.pickle)

  }

}
