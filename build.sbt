name := "closedloop"

version := "0.1"

scalaVersion := "2.13.5"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-fs2",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser",
  "io.circe" %% "circe-refined"
).map(_ % "0.13.0")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.2" % Test


