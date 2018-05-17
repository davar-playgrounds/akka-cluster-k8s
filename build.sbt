scalaVersion := "2.12.6"

val versionAkkaMgnt = "0.13.0"
val versionAkkaHttp = "10.1.1"
val versionAkka = "2.5.12"

libraryDependencies ++= Seq(
  "com.lightbend.akka.management" %% "akka-management-cluster-bootstrap" % versionAkkaMgnt,
  "com.lightbend.akka.discovery" %% "akka-discovery-kubernetes-api" % versionAkkaMgnt
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % versionAkkaHttp,
  "com.typesafe.akka" %% "akka-http-testkit" % versionAkkaHttp % Test
)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-cluster-sharding" %  versionAkka,
  "com.typesafe.akka" %% "akka-cluster" % versionAkka,
  "com.typesafe.akka" %% "akka-slf4j" % versionAkka
)

libraryDependencies += (
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)

enablePlugins(JavaServerAppPackaging)

packageName in Docker := "akka-k8s"
// update the image with the latest tag
dockerUpdateLatest := true
// use a custom alpine image with bash
dockerBaseImage := "local/openjdk-jre-8-bash"

mainClass in Compile := Some("com.github.leifh.akka.Main")