import sbt.Keys._

lazy val commonSettings = Seq(
  organization := "me.lessis",

  name := "courier",

  version := "0.1.4-SNAPSHOT",

  description := "deliver electronic mail with scala",

  libraryDependencies ++= Seq(
    "com.sun.mail" % "javax.mail" % "1.5.5"
  ),

  licenses := Seq(
    ("MIT", url(s"https://github.com/softprops/${name.value}/blob/${version.value}/LICENSE"))),

  homepage := Some(url(s"https://github.com/softprops/${name.value}/#readme")),

  scalaVersion := "2.11.8",
  crossScalaVersions := Seq("2.10.6", "2.11.8")
)

val cmdlineProfile = sys.props.getOrElse("sbt.profile", default = "")

def profile: Project ⇒ Project = p => cmdlineProfile match {
  case "2.12.x" => p.disablePlugins(scoverage.ScoverageSbtPlugin)
  case _ => p
}

lazy val root = (project in file("."))
    .configure(profile)
    .settings(commonSettings: _*)


//scalaVersion := crossScalaVersions.value.last
//
//seq(bintraySettings:_*)
//
//bintray.Keys.packageLabels in bintray.Keys.bintray := Seq("email", "mail", "javamail")
//
//seq(lsSettings:_*)
//
//LsKeys.tags in LsKeys.lsync := (bintray.Keys.packageLabels in bintray.Keys.bintray).value
//
//externalResolvers in LsKeys.lsync := (resolvers in bintray.Keys.bintray).value

//pomExtra := (
//  <scm>
//    <url>git@github.com:softprops/courier.git</url>
//    <connection>scm:git:git@github.com:softprops/courier.git</connection>
//  </scm>
//  <developers>
//    <developer>
//      <id>softprops</id>
//      <name>Doug Tangren</name>
//      <url>https://github.com/softprops</url>
//    </developer>
//  </developers>)

