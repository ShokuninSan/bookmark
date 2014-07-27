package io.flatmap.components

import io.flatmap.models.Bookmark
import com.mongodb.casbah.MongoClient
import com.novus.salat._
import com.novus.salat.global._

trait DaoComponent {

  trait Dao {

    def write(bookmark: Bookmark): Unit

  }

}

trait MongoDaoComponentImpl extends DaoComponent {

  val mongoServer: String
  val mongoPort: Int
  val mongoDb: String
  val mongoCollection: String

  object MongoFactory {

    val connection = MongoClient(mongoServer, mongoPort)
    val collection = connection(mongoDb)(mongoCollection)

  }

  class MongoDaoImpl extends Dao {

    val collection = MongoFactory.collection

    def write(bookmark: Bookmark): Unit = collection.save(grater[Bookmark].asDBObject(bookmark))

  }

}
