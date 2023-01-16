package com.memksim.timetracker

import android.app.Application
import com.google.firebase.FirebaseApp

class TimeTrackerApp: Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }

}