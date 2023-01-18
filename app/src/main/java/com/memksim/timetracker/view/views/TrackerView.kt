package com.memksim.timetracker.view.views

import com.arellomobile.mvp.MvpView

interface TrackerView: MvpView {
    fun pauseTracking()
    fun startTracking()
    fun stopTracking(info: String)
    fun resetTracking()
    fun setHours(time: String)
    fun setMinutes(time: String)
    fun setTotalTimeTitle(time: String)
    fun setProjectTimeTitle(time: String)
}