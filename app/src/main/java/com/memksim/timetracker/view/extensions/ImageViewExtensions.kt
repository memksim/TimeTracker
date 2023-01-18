package com.memksim.timetracker.view.extensions

import android.content.res.Resources
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat

fun ImageView.setIcon(
    resources: Resources,
    iconId: Int
){
    setImageDrawable(
        ResourcesCompat.getDrawable(
            resources,
            iconId,
            null
        )
    )
}