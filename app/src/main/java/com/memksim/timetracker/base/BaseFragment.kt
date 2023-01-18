package com.memksim.timetracker.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.MvpAppCompatFragment

abstract class BaseFragment<T: ViewBinding>(
    private val layoutId: Int,
    binder: (View) -> T
): MvpAppCompatFragment() {

    val binding by viewBinding(binder)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

}