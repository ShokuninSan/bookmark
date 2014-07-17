package io.flatmap.components

import io.flatmap.models.Bookmark
import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject
import com.mongodb.casbah.MongoClient

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

    def write(bookmark: Bookmark): Unit = {
      val obj = buildMongoDbObject(bookmark)
      MongoFactory.collection.save(obj)
    }

    private def buildMongoDbObject(bookmark: Bookmark): DBObject = {
      val builder = MongoDBObject.newBuilder
      builder += "url" -> bookmark.url
      builder += "comment" -> bookmark.comment
      builder.result
    }

  }

}
