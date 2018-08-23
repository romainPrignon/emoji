val corePackage = "core.Index"
val coreTestPackage = "core.IndexTest"

lazy val root = (project in file("."))
  .settings(
    name := "Emoji",
    scalaVersion := "2.12.6",
    scalaSource in Compile := baseDirectory.value / "src",
    scalaSource in Test := baseDirectory.value / "test",
    mainClass in (Compile, run) := Some(corePackage),
    mainClass in (Test, run) := Some(coreTestPackage),
    libraryDependencies ++= Seq(
        "org.scalaj" %% "scalaj-http" % "2.4.1",
        "io.argonaut" %% "argonaut" % "6.2.1",
        "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test"
    )
  )