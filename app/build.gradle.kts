plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
    id("com.google.gms.google-services")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.memksim.timetracker"
        minSdk = 22
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APPCOMPAT)

    //Firebase
    implementation(Dependencies.Firebase.CORE)
    implementation(Dependencies.Firebase.ANALYTICS)

    //Ui
    implementation(Dependencies.Ui.MATERIAL)
    implementation(Dependencies.Ui.CONSTRAINT_LAYOUT)

    //Di
    kapt(Dependencies.Di.DAGGER_COMPILER)
    implementation(Dependencies.Di.DAGGER)

    //Lifecycle
    implementation(Dependencies.Lifecycle.VIEW_MODEL)
    implementation(Dependencies.Lifecycle.LIVE_DATA)
    kapt(Dependencies.Lifecycle.ANNOTATION_PROCESSOR)

    //Navigation
    implementation(Dependencies.Navigation.NAVIGATION_UI)
    implementation(Dependencies.Navigation.NAVIGATION_FRAGMENT)

    //Test
    testImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.Test.EXT_JUNIT)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
}