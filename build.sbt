name := "enumeratum-mongodb"

ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.2.0"

inThisBuild(
  List(
    organization := "com.github.alonsodomin",
    homepage := Some(url("https://github.com/alonsodomin/enumeratum-mongodb")),
    licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
    developers := List(
      Developer(
        "alonsodomin",
        "Antonio Alonso Dominguez",
        "work@alonsodomin.me",
        url("https://www.alonsodomin.me")
      )
    )
  )
)

val slf4jVersion = "1.7.30"

libraryDependencies ++= Seq(
  "org.mongodb.scala"      %% "mongo-scala-driver"   % "2.9.0",
  "com.beachape"           %% "enumeratum"           % "1.5.15",
  "org.slf4j"              % "slf4j-api"             % slf4jVersion % Test,
  "org.slf4j"              % "slf4j-simple"          % slf4jVersion % Test,
  "org.scalatest"          %% "scalatest"            % "3.1.1" % Test,
  //"com.github.simplyscala" %% "scalatest-embedmongo" % "0.3.0" % Test //ADDED LOCALLY WAITING FOR PR TO BE AVAILABLE
)

addCommandAlias(
  "fmt",
  Seq("scalafmtSbt", "scalafmt", "test:scalafmt").mkString(";")
)

addCommandAlias(
  "checkfmt",
  Seq("scalafmtSbtCheck", "scalafmtCheck", "test:scalafmtCheck").mkString(";")
)

addCommandAlias(
  "validate",
  Seq("checkfmt", "test").mkString(";")
)

addCommandAlias(
  "rebuild",
  Seq("clean", "validate").mkString(";")
)
