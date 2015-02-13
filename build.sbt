lazy val root = (project in file(".")).
  settings(
    name := "wave",
    version := "0.1",
    organization := "ru.reo7sp",
    mainClass := Some("Core")
  )
