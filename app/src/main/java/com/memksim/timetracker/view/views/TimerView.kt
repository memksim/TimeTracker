package com.memksim.timetracker.view.views

interface TimerView: NavigableView {
    fun updateTimerText(time: String)
    fun startTimer(isTimerRunning: Boolean)
    fun pauseTimer(isTimerRunning: Boolean)
    fun stopTimer()
    fun resetTimer()
    fun setStartButtonActive(isActivated: Boolean)
    fun setProgressMax(max: Int)
    fun setProgress(progress: Int)
}