package com.memksim.timetracker.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.memksim.timetracker.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}