package com.memksim.timetracker.view.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.memksim.timetracker.base.CountUpTimer
import com.memksim.timetracker.view.views.TrackerView

@InjectViewState
class TrackerPresenter: MvpPresenter<TrackerView>() {

    private var lastTime: Long = 0

    private var timer: CountUpTimer? = null

    fun startTimer(){
        formatAndSendDate()

        timer = CountUpTimer(
            this::tick,
            this::tickStops
        ).apply {
            start()
        }
    }

    fun stopTimer(){
        timer?.cancel()
        viewState.stopTracking("Stopped!")
    }

    private fun tick(time: Long){
        lastTime = time
        formatAndSendDate()
    }

    private fun formatAndSendDate(){
        val minutes = (lastTime / (1000 * 60)) % 60
        if(minutes < 10){
            viewState.setMinutes("0$minutes")
        }else{
            viewState.setMinutes(minutes.toString())
        }

        val hours = (lastTime / (1000 * 60 * 60)) % 24
        if(hours < 10){
            viewState.setHours("0$hours")
        }else{
            viewState.setHours(hours.toString())
        }
    }

    private fun tickStops(message: String){
        //viewState.stopTracking()
    }

}