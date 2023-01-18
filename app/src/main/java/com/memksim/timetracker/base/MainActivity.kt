package com.memksim.timetracker.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.memksim.timetracker.R
import com.memksim.timetracker.view.fragments.TimeTrackerFragment

class MainActivity : MvpAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){

            supportFragmentManager.beginTransaction().add(R.id.fragment_container_view, TimeTrackerFragment()).commit()
        }
    }
}