package com.memksim.timetracker.view.views

import com.arellomobile.mvp.MvpView

interface TrackerView: MvpView {
    fun pauseTracking()
    fun startTracking()
    fun stopTracking()
    fun resetTracking()
    fun setHours(time: Int)
    fun setMinutes(time: Int)
    fun setSeconds(time: Int)
    fun setTotalTimeTitle(time: Int)
    fun setProjectTimeTitle(time: Int)
}