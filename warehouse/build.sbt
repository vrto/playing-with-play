name := """warehouse"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "com.google.guava" % "guava" % "14.0",
  "org.projectlombok" % "lombok" % "1.14.8"
)

transitiveClassifiers := Seq("sources")