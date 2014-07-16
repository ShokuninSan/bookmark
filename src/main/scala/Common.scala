package io.flatmap

import com.mongodb.casbah.commons.MongoDBObject
import io.flatmap.models.Bookmark
import com.mongodb.DBObject

object Common {

  def buildMongoDbObject(bookmark: Bookmark): DBObject = {
    val builder = MongoDBObject.newBuilder
    builder += "url" -> bookmark.url
    builder += "comment" -> bookmark.comment
    builder.result
  }

}
