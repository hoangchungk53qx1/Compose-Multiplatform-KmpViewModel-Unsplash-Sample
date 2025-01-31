plugins {
  kotlin("multiplatform")
  id("com.android.application")
  id("org.jetbrains.compose")
}

val koinVersion = "3.5.0"

kotlin {
  androidTarget()

  sourceSets {
    val androidMain by getting {
      dependencies {
        implementation(project(":feature_search_photo_shared"))
        implementation(project(":feature_photo_detail_shared"))
        implementation(project(":libraries:koin-utils"))
        implementation(project(":libraries:koin-compose-utils"))
        implementation(project(":libraries:coroutines-utils"))

        implementation(projects.core.commonShared)
        implementation(projects.core.commonUiShared)
        implementation(projects.core.navigationShared)

        // Koin Android
        implementation("io.insert-koin:koin-android:$koinVersion")
        implementation("io.insert-koin:koin-androidx-compose:3.4.6")
      }
    }
  }
}

android {
  compileSdk = (findProperty("android.compileSdk") as String).toInt()
  namespace = "com.hoc081098.compose_multiplatform_kmpviewmodel_sample"

  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

  defaultConfig {
    applicationId = "com.hoc081098.compose_multiplatform_kmpviewmodel_sample"
    minSdk = (findProperty("android.minSdk") as String).toInt()
    targetSdk = (findProperty("android.targetSdk") as String).toInt()
    versionCode = 1
    versionName = "1.0"
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlin {
    jvmToolchain(17)
  }

  packagingOptions {
    exclude("META-INF/versions/9/previous-compilation-data.bin")
  }
}
