package com.memksim.timetracker.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.memksim.timetracker.R
import com.memksim.timetracker.base.BaseFragment
import com.memksim.timetracker.databinding.FragmentTimeTrackerBinding
import com.memksim.timetracker.view.presenters.TrackerPresenter
import com.memksim.timetracker.view.views.TimerView

class TimeTimerFragment : BaseFragment<FragmentTimeTrackerBinding>(
    R.layout.fragment_time_tracker,
    FragmentTimeTrackerBinding::bind
), TimerView {

    @InjectPresenter
    lateinit var trackerPresenter: TrackerPresenter

    @ProvidePresenter
    fun provideTrackerPresenter(): TrackerPresenter = TrackerPresenter()

    val args: TimeTimerFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //trackerPresenter.initTimer(args.time)
        trackerPresenter.initTimer(60_000L)
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

    private fun setPlayButtonActivated(isActive: Boolean) {
        with(binding) {
            actionButtons.playPauseTimer.background = ResourcesCompat
                .getDrawable(
                    resources,
                    if (isActive) {
                        R.drawable.play_button_background
                    } else {
                        R.drawable.inactive_play_button_background
                    },
                    null
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

    override fun setStartButtonActive() {
        with(binding.actionButtons) {
            playPauseTimer.isClickable = true
            playPauseTimerInactivate.isVisible = false
        }
    }

    override fun setStartButtonInactive() {
        with(binding.actionButtons) {
            playPauseTimer.isClickable = false
            playPauseTimerInactivate.isVisible = true
        }
    }

}