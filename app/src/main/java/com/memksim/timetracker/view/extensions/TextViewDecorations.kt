package com.memksim.timetracker.view.extensions

import android.content.res.Resources
import android.os.Build
import android.widget.TextView
import com.memksim.timetracker.R

fun TextView.decorate(
    isActive: Boolean,
    resources: Resources
){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if(isActive){
            setTextColor(resources.getColor(R.color.teal_200, null))
        }else {
            setTextColor(resources.getColor(R.color.grey, null))
        }
    }
}