package com.memksim.timetracker.view.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.memksim.timetracker.view.views.SetTimeView

@InjectViewState
class SetTimePresenter : MvpPresenter<SetTimeView>() {

    private val nums: Array<Int> = Array(6) { -1 } //[h, h, m, m, s, s]

    fun setNumber(number: Int) {
        if (nums[0] == -1) {
            nums[0] = nums[1]
            nums[1] = nums[2]
            nums[2] = nums[3]
            nums[3] = nums[4]
            nums[4] = nums[5]
            nums[5] = number
        }
        setNumsInUi()
    }

    fun removeNumber() {
        if (nums[5] != -1) {
            nums[5] = nums[4]
            nums[4] = nums[3]
            nums[3] = nums[2]
            nums[2] = nums[1]
            nums[1] = nums[0]
            nums[0] = -1
        }
        setNumsInUi()
    }

    fun clearNumbers() {
        nums[5] = -1
        nums[4] = -1
        nums[3] = -1
        nums[2] = -1
        nums[1] = -1
        nums[0] = -1
        setNumsInUi()
    }

    fun navigateToTimeTracker() {
        viewState.navigate(numsToMillis())
    }

    private fun setNumsInUi() {
        val resultArray = nums.map {
            return@map if (it == -1) {
                0
            } else {
                it
            }
        }
        val hour = resultArray[0].toString() + resultArray[1].toString()
        val min = resultArray[2].toString() + resultArray[3].toString()
        val sec = resultArray[4].toString() + resultArray[5].toString()

        viewState.setTime(hour, min, sec)
        viewState.decorateSeconds(isActive = (nums[5] != -1))
        viewState.decorateMinutes(isActive = (nums[3] != -1))
        viewState.decorateHours(isActive = (nums[1] != -1))
        viewState.showHidePlayButton(isActive = (nums[5] != -1))
    }

    private fun numsToMillis(): Long {
        val hours: Long = if (nums[1] != -1) {
            ((nums[0] * 10 + nums[1]) * 1_440_000).toLong()
        } else {
            0L
        }
        val mins = if (nums[3] != -1) {
            ((nums[2] * 10 + nums[3]) * 60_000).toLong()
        } else {
            0L
        }
        val secs = if (nums[5] != -1) {
            ((nums[4] * 10 + nums[5]) * 1_000).toLong()
        } else {
            0L
        }
        return hours + mins + secs
    }

}