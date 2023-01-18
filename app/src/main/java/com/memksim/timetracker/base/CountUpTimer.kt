package com.memksim.timetracker.base

import android.os.CountDownTimer

class CountUpTimer(
    private val listener: (ms: Long) -> Unit,
    private val finishListener: (msg: String) -> Unit,
    private val millisInFuture: Long = 86_400_000,//максимум сутки
    private val countDownInterval: Long = 60_000 // 1 минута
) : CountDownTimer(
    millisInFuture,
    countDownInterval
) {
    override fun onTick(msUntilFinished: Long) {
        listener(millisInFuture - msUntilFinished)
    }

    override fun onFinish() {
        finishListener("Достигнут максимальный лимит времени за 1 сессию!")
    }
}