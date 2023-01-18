
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
    id("com.google.gms.google-services")
}

android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.memksim.timetracker"
        minSdk = 22
        targetSdk = 33
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APPCOMPAT)

    //Firebase
    implementation(Dependencies.Firebase.CORE)
    implementation(Dependencies.Firebase.ANALYTICS)
    implementation(Dependencies.Firebase.FIRESTORE)

    //Ui
    implementation(Dependencies.Ui.MATERIAL)
    implementation(Dependencies.Ui.CONSTRAINT_LAYOUT)

    //Room
    implementation(Dependencies.Room.RUNTIME)
    kapt(Dependencies.Room.COMPILER)
    implementation(Dependencies.Room.KTX)
    implementation(Dependencies.Room.RX_JAVA)

    //RxJava
    implementation(Dependencies.RxJava.RX_JAVA)

    //ViewBinding property delegate by AndroidBroadcast
    implementation(Dependencies.VIEW_BINDING_PROPERTY_DELEGATE)

    //Di
    kapt(Dependencies.Di.DAGGER_COMPILER)
    implementation(Dependencies.Di.DAGGER)

    //Moxy
    implementation(Dependencies.Moxy.MOXY_X)
    kapt(Dependencies.Moxy.COMPILER)
    implementation(Dependencies.Moxy.ANDROIDX)

    //Navigation
    implementation(Dependencies.Navigation.NAVIGATION_UI)
    implementation(Dependencies.Navigation.NAVIGATION_FRAGMENT)

    //Test
    testImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.Test.EXT_JUNIT)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
}