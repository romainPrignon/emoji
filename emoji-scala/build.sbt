val corePackage = "core.Index"

lazy val root = (project in file("."))
  .settings(
    name := "Emoji",
    scalaVersion := "2.12.6",
    scalaSource in Compile := baseDirectory.value / "src",
    scalaSource in Test := baseDirectory.value / "test",
    mainClass in (Compile, run) := Some(corePackage),
    libraryDependencies ++= Seq(
        "org.scalaj" %% "scalaj-http" % "2.4.1",
        "io.argonaut" %% "argonaut" % "6.2.1"
    )
  )