name := "SudokuSolver"
version := "0.1"
organization := "phuong.sudoku"
scalaVersion := "2.12.8"

assemblyJarName in assembly := "SudokuSolver.jar"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % "2.12.8",
  "org.scala-lang" % "scala-reflect" % "2.12.8"
)

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

unmanagedResourceDirectories in Compile += baseDirectory.value / "src"
excludeFilter in unmanagedResourceDirectories := "*.scala"