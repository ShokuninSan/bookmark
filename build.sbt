seq(conscriptSettings :_*)

organization := "io.flatmap"

name := "bookmark"

version := "0.1.0"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "org.slf4j" % "slf4j-simple" % "1.6.4",
  "org.mongodb" %% "casbah" % "2.6.4"
)
