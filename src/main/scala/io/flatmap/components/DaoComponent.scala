package io.flatmap.components

import io.flatmap.models.Bookmark
import io.flatmap.Common._
import io.flatmap.MongoFactory

trait DaoComponent {

  trait Dao {

    def write(bookmark: Bookmark): Unit

  }

}

trait DaoComponentImpl extends DaoComponent {

  class DaoImpl extends Dao {

    def write(bookmark: Bookmark): Unit = {
      val obj = buildMongoDbObject(bookmark)
      MongoFactory.collection.save(obj)
    }

  }

}
