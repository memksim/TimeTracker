package com.memksim.timetracker.base

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.memksim.timetracker.R

class MainActivity : MvpAppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}