package com.memksim.timetracker.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.navigation.NavDirections
import androidx.navigation.fragment.navArgs
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.memksim.timetracker.R
import com.memksim.timetracker.base.BaseFragment
import com.memksim.timetracker.databinding.FragmentTimeTrackerBinding
import com.memksim.timetracker.view.presenters.TrackerPresenter
import com.memksim.timetracker.view.views.NavigableView
import com.memksim.timetracker.view.views.TimerView

class TimeTrackerFragment : BaseFragment<FragmentTimeTrackerBinding>(
    R.layout.fragment_time_tracker,
    FragmentTimeTrackerBinding::bind
), TimerView, NavigableView {

    @InjectPresenter
    lateinit var trackerPresenter: TrackerPresenter

    @ProvidePresenter
    fun provideTrackerPresenter(): TrackerPresenter = TrackerPresenter()

    val args: TimeTrackerFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        trackerPresenter.initTimer(args.time)
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
            timeTracker.timeTv.setOnClickListener {
                trackerPresenter.navigateToSetTimeFragment()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        trackerPresenter.initTimer(args.time)
    }

    private fun startPauseTracking(isTimerRunning: Boolean) {
        with(binding) {
            actionButtons.playPauseTimer.background = ResourcesCompat
                .getDrawable(
                    resources,
                    if (!isTimerRunning) {
                        R.drawable.play_button_background
                    } else {
                        R.drawable.pause_button_background
                    },
                    null
                )
            timeTracker.run {
                timeTv.setTextColor(
                    ContextCompat.getColor(
                        requireContext(), if (!isTimerRunning) {
                            R.color.grey
                        } else {
                            R.color.black
                        }
                    )
                )
            }
            startPauseTitle.text = getString(
                if (!isTimerRunning) {
                    R.string.paused
                } else {
                    R.string.work_time
                }
            )
        }
    }

    override fun updateTimerText(time: String) {
        binding.timeTracker.timeTv.text = time
    }

    override fun startTimer(isTimerRunning: Boolean) {
        startPauseTracking(isTimerRunning = isTimerRunning)
    }

    override fun pauseTimer(isTimerRunning: Boolean) {
        startPauseTracking(isTimerRunning = isTimerRunning)
    }

    override fun stopTimer() {
        startPauseTracking(isTimerRunning = false)
    }

    override fun resetTimer() {

    }

    override fun setStartButtonActive(isActivated: Boolean) {
        with(binding.actionButtons) {
            playPauseTimer.isClickable = isActivated
            playPauseTimerInactivate.isVisible = isActivated.not()
        }
    }

    override fun setProgressMax(max: Int) {
        binding.timeTracker.timerProgress.max = max
        binding.timeTracker.timerProgress.progress = 0
    }

    override fun setProgress(progress: Int) {
        binding.timeTracker.timerProgress.progress = progress
    }

    override fun navigate(args: Any?) {
        val action = TimeTrackerFragmentDirections
            .actionTimeTrackerFragmentToSetTimeFragment()
        navigateTo(action = action)
    }

}