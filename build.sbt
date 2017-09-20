import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      scalaOrganization := "org.typelevel", // provide literal types
      scalaVersion := "2.12.3-bin-typelevel-4",
      version      := "0.1.0-SNAPSHOT",
      scalacOptions ++= Seq(
        "-Yliteral-types",
        "-Ypartial-unification"
      )
    )),
    name := "BayesTrade Demo",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "spire" % "0.14.1",
      "org.typelevel" %% "cats-core" % "0.9.0", // algebra --> spire use 0.9.0. Update to 1.0.0 eventually.
      "net.sourceforge.f2j" % "arpack_combined_all" % "0.1",
      "com.github.fommil.netlib" % "all" % "1.1.2" // "core" will not pull any blas implemenations.
    ),
    initialCommands := """
      import math._
      import DenseMatrix._
      import com.github.fommil.netlib._
      import spire.std.double._
      import spire.algebra.VectorSpace
      import spire.syntax.vectorSpace._
    """
  )
