name := "scala-sbt-based-test"

version := "1.0"

scalaVersion := "2.12.1"

mainClass := Some("main/Startup.scala")

libraryDependencies +=
  "com.typesafe.akka" %% "akka-actor" % "2.4.16"