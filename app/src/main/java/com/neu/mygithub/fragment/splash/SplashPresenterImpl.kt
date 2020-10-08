package com.neu.mygithub.fragment.splash

import android.content.Context
import java.util.*

/**
 * implementação das regras de negócio da interface SplashPresenter
 * e ponte de notificações visuais para a SplashView */

class SplashPresenterImpl(
    private val context: Context,
    private val splashView: SplashView
) : SplashPresenter {

    /** Navega para ReposFragment em {delay} ms */
    override fun startTime(delay: Long) {

        val timerTask = object : TimerTask() {
            override fun run() {
                splashView.navigateToReposFragment()
            }
        }

        val timer = Timer()
        timer.schedule(timerTask, delay)
    }

}