package com.holmes.list.feature.splash

import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * 启动页面VM
 */
class SplashViewModel :ViewModel(){
    private var timer: CountDownTimer?=null

    /**
     * 倒计时秒数
     */
    private val _timeLeft = MutableStateFlow(0L)
    val timeLeft:StateFlow<Long> = _timeLeft

    /**
     * 是否跳转到主界面
     */
    val navigateToMain = MutableStateFlow(false)

    init {
        delayToNext()
    }

    private fun delayToNext(time:Long=1) {
        timer = object: CountDownTimer(time,1000){
            /**
             * 每次倒数计时执行
             */
            override fun onTick(millisUntilFinished: Long) {
                _timeLeft.value = millisUntilFinished/1000 + 1
            }

            /**
             * 倒计时结束执行
             */
            override fun onFinish() {
                toNext()
            }

        }.start()
    }

    private fun toNext() {
        navigateToMain.value = true
    }
}