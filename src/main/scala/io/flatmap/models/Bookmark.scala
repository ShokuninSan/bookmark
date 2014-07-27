package io.flatmap.models

import org.joda.time.DateTime

case class Bookmark(url: String, description: String, addDate: Option[DateTime] = None, lastModified: Option[DateTime] = None)
