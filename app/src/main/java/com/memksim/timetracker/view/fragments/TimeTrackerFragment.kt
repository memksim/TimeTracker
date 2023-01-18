package com.memksim.timetracker.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.memksim.timetracker.R
import com.memksim.timetracker.base.BaseFragment
import com.memksim.timetracker.databinding.FragmentTimeTrackerBinding
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
        with(binding) {
            actionButtons.run {
                playPauseTimer.setOnClickListener {
                    trackerPresenter.startPauseTimer()
                }

                stopTimer.setOnClickListener {
                    trackerPresenter.stopTimer()
                }

                resetTimer.setOnClickListener {
                    trackerPresenter.resetTimer()
                }
            }
        }
    }

    override fun pauseTracking() {
        startPauseTracking(isPaused = true)
    }

    override fun startTracking() {
        startPauseTracking(isPaused = false)
    }

    override fun stopTracking(info: String) {
        Toast.makeText(requireContext(), info, Toast.LENGTH_SHORT).show()
    }

    override fun resetTracking() {
        //TODO("Not yet implemented")
    }

    override fun setHours(time: String) {
        binding.timeTracker.hoursTimeTv.text = time
    }

    override fun setMinutes(time: String) {
        binding.timeTracker.minutesTimeTv.text = ":${time}"
    }

    override fun setTotalTimeTitle(time: String) {
        binding.totalTimeToday.text = getString(R.string.total_time_tracked_today) + time
    }

    override fun setProjectTimeTitle(time: String) {
        binding.totalProjectTime.text = getString(R.string.total_time_tracked_on_project) + time
    }

    private fun startPauseTracking(isPaused: Boolean) {
        with(binding) {
            actionButtons.playPauseTimer.background = ResourcesCompat
                .getDrawable(
                    resources,
                    if (isPaused) {
                        R.drawable.play_button_background
                    } else {
                        R.drawable.pause_button_background
                    },
                    null
                )
            timeTracker.run {
                hoursTimeTv.setTextColor(
                    ContextCompat.getColor(
                        requireContext(), if (isPaused) {
                            R.color.grey
                        } else {
                            R.color.black
                        }
                    )
                )
                minutesTimeTv.setTextColor(
                    ContextCompat.getColor(
                        requireContext(), if (isPaused) {
                            R.color.grey
                        } else {
                            R.color.black
                        }
                    )
                )
            }
            startPauseTitle.text = getString(
                if (isPaused) {
                    R.string.paused
                } else {
                    R.string.work_time
                }
            )
        }
    }

}