package com.memksim.timetracker.view.views

import com.arellomobile.mvp.MvpView

interface NavigableView: MvpView {
    fun navigate(args: Any? = null)
}