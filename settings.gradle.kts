rootProject.name = "KmpViewModel Compose Multiplatform"

include(":androidApp")
include(":desktopApp")
include(":feature_search_photo_shared")
include(":feature_photo_detail_shared")
include(":common_shared")
include(":common_ui_shared")
include(":navigation_shared")
include(":libraries:koin-utils")
include(":libraries:koin-compose-utils")

pluginManagement {
  repositories {
    gradlePluginPortal()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
  }

  plugins {
    val kotlinVersion = extra["kotlin.version"] as String
    val agpVersion = extra["agp.version"] as String
    val composeVersion = extra["compose.version"] as String

    kotlin("jvm").version(kotlinVersion)
    kotlin("multiplatform").version(kotlinVersion)
    kotlin("android").version(kotlinVersion)
    kotlin("plugin.serialization").version(kotlinVersion)

    id("com.android.application").version(agpVersion)
    id("com.android.library").version(agpVersion)

    id("org.jetbrains.compose").version(composeVersion)

    id("com.codingfeline.buildkonfig").version("0.13.3")
    id("com.google.devtools.ksp").version("1.9.0-1.0.13")
    id("com.diffplug.gradle.spotless").version("6.20.0")
  }
}

dependencyResolutionManagement {
  repositories {
    google()
    mavenCentral()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/")
  }
}
