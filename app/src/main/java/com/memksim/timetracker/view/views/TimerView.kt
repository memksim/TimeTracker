package com.memksim.timetracker.view.views

import com.arellomobile.mvp.MvpView

interface TimerView: MvpView {
    fun updateTimerText(time: String)
    fun startTimer(isTimerRunning: Boolean)
    fun pauseTimer(isTimerRunning: Boolean)
    fun stopTimer()
    fun resetTimer()
    fun setStartButtonActive()
    fun setStartButtonInactive()
}