package com.memksim.timetracker.base

import android.app.Application
import com.google.firebase.FirebaseApp
import com.memksim.timetracker.di.components.AppComponent
import com.memksim.timetracker.di.components.DaggerAppComponent

class TimeTrackerApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        appComponent = DaggerAppComponent.builder()
            .context(context = this)
            .build()
    }

}