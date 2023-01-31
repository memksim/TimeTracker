package com.memksim.timetracker.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.memksim.timetracker.R
import com.memksim.timetracker.base.BaseFragment
import com.memksim.timetracker.databinding.FragmentSetTimeBinding
import com.memksim.timetracker.view.extensions.decorate
import com.memksim.timetracker.view.presenters.SetTimePresenter
import com.memksim.timetracker.view.views.SetTimeView

class SetTimeFragment: BaseFragment<FragmentSetTimeBinding>(
    R.layout.fragment_set_time,
    FragmentSetTimeBinding::bind
), SetTimeView {

    @InjectPresenter
    lateinit var presenter: SetTimePresenter

    @ProvidePresenter
    fun providePresenter(): SetTimePresenter = SetTimePresenter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            appBar.setNavigationOnClickListener {
                navigateTo(
                    action = SetTimeFragmentDirections.actionSetTimeFragmentToTimeTrackerFragment()
                )
            }
            with(numbers){
                button1.setOnClickListener {
                    presenter.setNumber(1)
                }
                button2.setOnClickListener {
                    presenter.setNumber(2)
                }
                button3.setOnClickListener {
                    presenter.setNumber(3)
                }
                button4.setOnClickListener {
                    presenter.setNumber(4)
                }
                button5.setOnClickListener {
                    presenter.setNumber(5)
                }
                button6.setOnClickListener {
                    presenter.setNumber(6)
                }
                button7.setOnClickListener {
                    presenter.setNumber(7)
                }
                button8.setOnClickListener {
                    presenter.setNumber(8)
                }
                button9.setOnClickListener {
                    presenter.setNumber(9)
                }
                button00.setOnClickListener {

                }
                button0.setOnClickListener {
                    presenter.setNumber(0)
                }
                buttonRemove.setOnClickListener {
                    presenter.removeNumber()
                }
                buttonDelete.setOnClickListener {
                    presenter.clearNumbers()
                }
            }
            playPauseTimer.setOnClickListener {
                presenter.navigateToTimeTracker()
            }
        }
    }

    override fun setTime(h: String, m: String, s: String) {
        binding.selectedTime.run{
            hoursTv.text = h
            minutesTv.text = m
            secondsTv.text = s
        }
    }

    override fun showHidePlayButton(isActive: Boolean) {
        binding.playPauseTimer.isVisible = isActive
    }

    override fun decorateSeconds(isActive: Boolean) {
        with(binding.selectedTime){
            secondsTitle.decorate(isActive = isActive, resources = resources)
            secondsTv.decorate(isActive = isActive, resources = resources)
        }
    }

    override fun decorateMinutes(isActive: Boolean) {
        with(binding.selectedTime){
            minutesTitle.decorate(isActive = isActive, resources = resources)
            minutesTv.decorate(isActive = isActive, resources = resources)
        }
    }

    override fun decorateHours(isActive: Boolean) {
        with(binding.selectedTime){
            hoursTitle.decorate(isActive = isActive, resources = resources)
            hoursTv.decorate(isActive = isActive, resources = resources)
        }
    }

    override fun navigate(args: Any?) {
        val action = SetTimeFragmentDirections
            .actionSetTimeFragmentToTimeTrackerFragment()
            .setTime(args as Long)
        navigateTo(action = action)
    }



}