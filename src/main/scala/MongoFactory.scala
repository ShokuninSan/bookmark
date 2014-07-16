package io.flatmap

import com.mongodb.casbah.{MongoClient, MongoConnection}

object MongoFactory {

  private val SERVER = "146.255.56.42"
  private val PORT = 27017
  private val DATABASE = "mydb"
  private val COLLECTION = "testData"

  val connection = MongoClient(SERVER, PORT)
  val collection = connection(DATABASE)(COLLECTION)
}
