package com.memksim.timetracker.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
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
            trackerPresenter.startTimer()
        }
        binding.actionButtons.stopTimer.setOnClickListener {
            trackerPresenter.stopTimer()
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

    override fun stopTracking(info: String) {
        Toast.makeText(requireContext(), info, Toast.LENGTH_SHORT).show()
    }

    override fun resetTracking() {
        //TODO("Not yet implemented")
    }

    override fun setHours(time: String) {
        binding.timeTracker.hoursTimeTv.text = time.toString()
    }

    override fun setMinutes(time: String) {
        binding.timeTracker.minutesTimeTv.text = ":${time}"
    }

    override fun setTotalTimeTitle(time: String) {
        binding.totalProjectTime.text = getString(R.string.total_time_tracked_on_project) + time
    }

    override fun setProjectTimeTitle(time: String) {
        binding.totalTimeToday.text = getString(R.string.total_time_tracked_today) + time
    }

}