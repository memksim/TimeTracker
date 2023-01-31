package com.memksim.timetracker.view.views

interface SetTimeView: NavigableView {

    fun setTime(h: String, m: String, s: String)
    fun showHidePlayButton(isActive: Boolean)
    fun decorateSeconds(isActive: Boolean)
    fun decorateMinutes(isActive: Boolean)
    fun decorateHours(isActive: Boolean)

}