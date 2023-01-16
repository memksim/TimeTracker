// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.0" apply false
    id("com.android.library") version "7.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath(Dependencies.Navigation.SAFE_ARGS)
        classpath(Dependencies.GOOGLE_SERVICES)
    }
}

tasks.create<Delete>("cleanRP") {
    delete(
        rootProject.buildDir
    )
}