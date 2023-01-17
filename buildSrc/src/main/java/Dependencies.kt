object Dependencies {
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val GOOGLE_SERVICES = "com.google.gms:google-services:${Versions.GOOGLE_SERVICES}"

    object Ui {
        const val MATERIAL = "com.google.android.material:material:${Versions.Ui.MATERIAL}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.Ui.CONSTRAINT_LAYOUT}"
    }

    object Test {
        const val JUNIT = "junit:junit:${Versions.Test.JUNIT}"
        const val EXT_JUNIT = "androidx.test.ext:junit:${Versions.Test.EXT_JUNIT}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.Test.ESPRESSO}"
    }

    object Di {
        const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.Di.DAGGER2}"
        const val DAGGER = "com.google.dagger:dagger:${Versions.Di.DAGGER2}"
    }

    object Navigation {
        const val NAVIGATION_FRAGMENT =
            "androidx.navigation:navigation-fragment-ktx:${Versions.Navigation.NAVIGATION_COMPONENT}"
        const val NAVIGATION_UI =
            "androidx.navigation:navigation-ui-ktx:${Versions.Navigation.NAVIGATION_COMPONENT}"
        const val SAFE_ARGS =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Navigation.NAVIGATION_COMPONENT}"
    }

    object Moxy {
        const val MOXY = "com.arello-mobile:moxy:${Versions.Moxy.MOXY}"
        const val COMPILER = "com.arello-mobile:moxy-compiler:${Versions.Moxy.MOXY}"
        const val ANDROID = "com.arello-mobile:moxy-android:${Versions.Moxy.MOXY}"
    }

    object Firebase {
        const val CORE = "com.google.firebase:firebase-core:${Versions.Firebase.CORE}"
        const val ANALYTICS =
            "com.google.firebase:firebase-analytics:${Versions.Firebase.ANALYTICS}"
        const val FIRESTORE =
            "com.google.firebase:firebase-firestore-ktx:${Versions.Firebase.FIRESTORE}"
    }

    object Room {
        const val RUNTIME = "androidx.room:room-runtime:${Versions.Room.ROOM}"
        const val COMPILER = "androidx.room:room-compiler:${Versions.Room.ROOM}"
        const val KTX = "androidx.room:room-ktx:${Versions.Room.ROOM}"
    }
}