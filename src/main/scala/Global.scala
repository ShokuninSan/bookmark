package io.flatmap

import io.flatmap.components.{ConsoleHelperComponentImpl, MongoDaoComponentImpl, ServiceComponentImpl}

object BookmarkComponentsRegistry extends ConfigComponent with ConsoleHelperComponentImpl with ServiceComponentImpl with MongoDaoComponentImpl {

  val mongoServer = Config.get("db.server").get
  val mongoPort = Config.get("db.port").get.toInt
  val mongoDb = Config.get("db.name").get
  val mongoCollection = Config.get("db.collection").get

  val service = new ServiceImpl
  val dao = new MongoDaoImpl
  val consoleHelper = new ConsoleHelperImpl

}