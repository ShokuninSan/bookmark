package io.flatmap.components

import io.flatmap.models.Bookmark

trait ServiceComponent {

  trait Service {

    def write(bookmark: Bookmark): Unit

  }

}

trait ServiceComponentImpl extends ServiceComponent {

  this: DaoComponent =>

  val dao: Dao

  class ServiceImpl extends Service {

    def write(bookmark: Bookmark): Unit = dao.write(bookmark)

  }

}