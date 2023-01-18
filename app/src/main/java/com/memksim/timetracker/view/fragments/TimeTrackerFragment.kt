package com.memksim.timetracker.view.fragments

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.memksim.timetracker.R
import com.memksim.timetracker.base.BaseFragment
import com.memksim.timetracker.databinding.FragmentTimeTrackerBinding
import com.memksim.timetracker.model.repository.ProjectDatabaseRepository
import com.memksim.timetracker.view.extensions.setIcon
import com.memksim.timetracker.view.presenters.TrackerPresenter
import com.memksim.timetracker.view.views.TrackerView

class TimeTrackerFragment : BaseFragment<FragmentTimeTrackerBinding>(
    R.layout.fragment_time_tracker,
    FragmentTimeTrackerBinding::bind
), TrackerView {

    @InjectPresenter
    lateinit var trackerPresenter: TrackerPresenter

    @ProvidePresenter
    fun provideTrackerPresenter(): TrackerPresenter = TrackerPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.actionButtons.playPauseTimer.setOnClickListener {
            
        }
    }

    override fun pauseTracking() {
        binding.actionButtons.playPauseTimer
            .setIcon(
                resources = resources,
                iconId = R.drawable.ic_baseline_pause_circle_filled_24
            )
    }

    override fun startTracking() {
        binding.actionButtons.playPauseTimer
            .setIcon(
                resources = resources,
                iconId = R.drawable.ic_baseline_play_circle_filled_24
            )
    }

    override fun stopTracking() {
        //TODO("Not yet implemented")
    }

    override fun resetTracking() {
        //TODO("Not yet implemented")
    }

    override fun setHours(time: Int) {
        binding.timeTracker.hoursTimeTv.text = time.toString()
    }

    override fun setMinutes(time: Int) {
        binding.timeTracker.minutesTimeTv.text = ":${time}"
    }

    override fun setSeconds(time: Int) {
        binding.timeTracker.secondsTimeTv.text = ":${time}"
    }

    override fun setTotalTimeTitle(time: Int) {
        binding.totalProjectTime.text = getString(R.string.total_time_tracked_on_project) + time.toString()
    }

    override fun setProjectTimeTitle(time: Int) {
        binding.totalTimeToday.text = getString(R.string.total_time_tracked_today) + time.toString()
    }

}