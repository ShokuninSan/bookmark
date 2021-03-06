seq(conscriptSettings :_*)

organization := "io.flatmap"

name := "bookmark"

version := "0.1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.mongodb" %% "casbah" % "2.6.4",
  "org.slf4j" % "slf4j-simple" % "1.6.0",
  "com.novus" %% "salat" % "1.9.5",
  "net.sourceforge.htmlcleaner" % "htmlcleaner" % "2.6.1"
)
