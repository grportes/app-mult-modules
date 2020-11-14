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
  .settings(defaultSettings, persistenceSettings)
  .dependsOn(commons)

lazy val admin = (project in file("modules/admin"))
  .enablePlugins(PlayJava)
  .settings(defaultSettings, persistenceSettings)
  .dependsOn(commons,repository)

lazy val transporte = (project in file("modules/transporte"))
  .enablePlugins(PlayJava)
  .settings(defaultSettings, persistenceSettings)
  .dependsOn(commons,repository)

lazy val defaultSettings = Seq(
  scalaVersion := "2.13.1",
  libraryDependencies ++= Seq(
    guice,
    javaJpa,
    "br.com.infra" % "infra-core_2.13" % "1.2"
  )
)

lazy val persistenceSettings = Seq(
  libraryDependencies ++= Seq(
    "br.com.infra" % "infra-jpa_2.13" % "1.2"
  )
)


PlayKeys.externalizeResources := false

// Resolve only newly added dependencies
//updateOptions := updateOptions.value.withCachedResolution(true)
//updateOptions := updateOptions.value.withLatestSnapshots(false)