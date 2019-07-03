import sbt._, Keys._

object CompilerOptions {

  val commonScalacOptions = Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-language:existentials",
    "-language:higherKinds",
    "-language:implicitConversions",
    "-unchecked",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard"
  )

  val update2_12 = Def.settings(
    scalacOptions -= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, 12)) => "-Yinline-warnings"
        case _ => ""
      }
    }
  )

  val noFatalWarningsInDoc = Def.settings(
    scalacOptions in(Compile, doc) :=
      (scalacOptions in(Compile, doc)).value.filter(_ != "-Xfatal-warnings")
  )

}
