package com.memksim.timetracker.view.presenters

import android.os.CountDownTimer
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.memksim.timetracker.view.views.NavigableView
import com.memksim.timetracker.view.views.TimerView
import java.util.*
import kotlin.math.max

@InjectViewState
class TrackerPresenter : MvpPresenter<TimerView>() {

    private var isTimerRunning = false
    private var timer: CountDownTimer? = null
    private var beingPaused = false
    private var maxTime: Long = 0
        set(value) {
            field = value
            viewState.setStartButtonActive(isActivated = (value != 0L))
        }
    private var timeLeftInMillis: Long = 0
    private val TICK_INTERVAL = 1_000L // 1 second

    fun initTimer(time: Long) {
        maxTime = time
        updateTimer(maxTime)
        viewState.setProgressMax(maxTime.toInt())
    }

    fun startPauseTimer() {
        if (isTimerRunning) {
            pauseTimer()
        } else {
            startTimer()
        }
    }

    fun resetTimer() {
        timeLeftInMillis = 0
        updateTimer(timeLeftInMillis)
        viewState.resetTimer()
        stopTimer()
        startTimer()
        beingPaused = false
        viewState.setProgress(timeLeftInMillis.toInt())
    }

    fun stopTimer() {
        timeLeftInMillis = 0
        updateTimer(maxTime)
        viewState.stopTimer()
        timer?.cancel()
        isTimerRunning = false
        beingPaused = false
        viewState.setProgress(timeLeftInMillis.toInt())
    }

    private fun pauseTimer() {
        timer?.cancel()
        isTimerRunning = false
        viewState.pauseTimer(isTimerRunning = isTimerRunning)
        beingPaused = true
    }

    private fun startTimer() {
        val inFuture = if (beingPaused) {
            timeLeftInMillis
        } else {
            maxTime
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
        beingPaused = false
        viewState.startTimer(isTimerRunning = isTimerRunning)
    }

    private fun updateTimer(time: Long) {
        val hours = (time / 61_440_000).toInt()
        val minutes = (time / 60_000).toInt()
        val seconds = ((time / 1_000) % 60).toInt()

        val timeLeftFormatted = String
            .format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds)

        viewState.updateTimerText(timeLeftFormatted)
    }

    fun navigateToSetTimeFragment(){
        viewState.navigate()
    }

}