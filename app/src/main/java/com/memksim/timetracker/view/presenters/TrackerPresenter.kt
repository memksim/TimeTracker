package com.memksim.timetracker.view.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.memksim.timetracker.utils.CountUpTimer
import com.memksim.timetracker.view.views.TrackerView

@InjectViewState
class TrackerPresenter : MvpPresenter<TrackerView>() {

    private var lastTime: Long = 0
    private var isPaused: Boolean = true

    private val timer = CountUpTimer(
        this::tick,
        this::tickStops
    )

    fun startPauseTimer() {
        if (isPaused) {
            timer.start()
            viewState.startTracking()
            isPaused = false
        } else {
            timer.cancel()
            viewState.pauseTracking()
            isPaused = true
        }
    }

    fun stopTimer() {
        timer.cancel()
        isPaused = true
        viewState.pauseTracking()
        viewState.setMinutes("00")
        viewState.setHours("00")
        viewState.setTotalTimeTitle("${getHours()}:${getMinutes()}")
        lastTime = 0
    }

    fun resetTimer() {
        timer.cancel()
        viewState.setMinutes("00")
        viewState.setHours("00")
        lastTime = 0
        timer.start()
    }

    private fun tick(time: Long) {
        lastTime = time
        viewState.setMinutes(getMinutes())
        viewState.setHours(getHours())
    }

    private fun getMinutes(): String {
        //todo оригинальная версия
        val minutes = (lastTime / (1000 * 60)) % 60
        //тут считает секунды вместо минуток, для простоты тестирования
        //val minutes = (lastTime / (1000)) % 60
        return if (minutes < 10) {
            "0$minutes"
        } else {
            minutes.toString()
        }
    }

    private fun getHours(): String {
        //todo оригинальная версия
        val hours = (lastTime / (1000 * 60 * 60)) % 24
        //тут считает минутки вместо часов, для простоты тестирования
        //val hours = (lastTime / (1000 * 60)) % 60
        return if (hours < 10) {
            "0$hours"
        } else {
            hours.toString()
        }
    }

    private fun tickStops(message: String) {
        viewState.stopTracking(message)
    }

}