name := """app-mult-modules"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .settings(defaultSettings)
  .dependsOn(commons,repository,admin,transporte)
  .aggregate(commons,repository,admin,transporte)

lazy val commons = (project in file("modules/commons"))
  .settings(defaultSettings)

lazy val repository = (project in file("modules/repository"))
  .settings(defaultSettings,persistenceSettings)
  .dependsOn(commons)

lazy val admin = (project in file("modules/admin"))
  .enablePlugins(PlayJava)
  .settings(defaultSettings)
  .dependsOn(commons,repository)

lazy val transporte = (project in file("modules/transporte"))
  .enablePlugins(PlayJava)
  .settings(defaultSettings)
  .dependsOn(commons,repository)

lazy val defaultSettings = Seq(
  scalaVersion := "2.12.6",
  libraryDependencies ++= Seq(
    guice,
    javaJpa,
    "br.com.infra" % "infra-core_2.12" % "1.0-SNAPSHOT"
  )
)

lazy val persistenceSettings = Seq(
  libraryDependencies ++= Seq(
    "br.com.infra" % "infra-jpa_2.12" % "1.0-SNAPSHOT"
  )
)

crossScalaVersions := Seq("2.11.12", "2.12.4")


// Testing libraries for dealing with CompletionStage...
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test

// Make verbose tests
testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))


PlayKeys.externalizeResources := false