package com.memksim.timetracker.view.presenters

import android.os.CountDownTimer
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.memksim.timetracker.view.views.TimerView
import java.util.*

@InjectViewState
class TrackerPresenter : MvpPresenter<TimerView>() {

    private var isTimerRunning = false
    private var timer: CountDownTimer? = null

    var timeLeftInMillis: Long = 0
    set(value) {
        field = value
        if(value != 0L){
            viewState.setStartButtonActive()
        }else{
            viewState.setStartButtonInactive()
        }
    }
    private var memorableTime = timeLeftInMillis
    private val TICK_INTERVAL = 1_000L // 1 second

    fun initTimer(time: Long){
        timeLeftInMillis = time
        memorableTime = timeLeftInMillis
        updateTimer(timeLeftInMillis)
        viewState.setProgressMax(timeLeftInMillis.toInt())
    }

    fun startPauseTimer() {
        if (isTimerRunning) {
            pauseTimer()
        } else {
            startTimer(fromMemory = false)
        }
    }

    fun resetTimer() {
        timeLeftInMillis = 0
        updateTimer(memorableTime)
        viewState.resetTimer()
        stopTimer()
        startTimer(fromMemory = true)
        viewState.setProgressMax(memorableTime.toInt())
        viewState.setProgress(timeLeftInMillis.toInt())
    }

    fun stopTimer() {
        timeLeftInMillis = 0
        memorableTime = 0
        updateTimer(timeLeftInMillis)
        viewState.stopTimer()
        timer?.cancel()
        isTimerRunning = false
        viewState.setProgressMax(memorableTime.toInt())
        viewState.setProgress(timeLeftInMillis.toInt())
    }

    private fun pauseTimer() {
        timer?.cancel()
        isTimerRunning = false
        viewState.pauseTimer(isTimerRunning = isTimerRunning)
    }

    private fun startTimer(fromMemory: Boolean) {
        val inFuture = if(fromMemory.not()){
            timeLeftInMillis
        }else{
            memorableTime
        }

        timer = object : CountDownTimer(
            inFuture,
            TICK_INTERVAL
        ) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateTimer(timeLeftInMillis)
                viewState.setProgress(timeLeftInMillis.toInt())
            }

            override fun onFinish() {
                isTimerRunning = false
                viewState.stopTimer()
                timeLeftInMillis = 0
            }
        }.start()

        isTimerRunning = true
        viewState.startTimer(isTimerRunning = isTimerRunning)
    }

    private fun updateTimer(time: Long){
        val hours = (time / 61_440_000).toInt()
        val minutes = (time / 60_000).toInt()
        val seconds = ((time / 1_000) % 60).toInt()

        val timeLeftFormatted = String
            .format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds)

        viewState.updateTimerText(timeLeftFormatted)
    }

}