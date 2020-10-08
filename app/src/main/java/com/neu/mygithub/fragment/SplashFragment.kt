package com.neu.mygithub.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.neu.mygithub.R
import java.util.*

class SplashFragment : Fragment() {

    private val navController: NavController
        get() {
            return NavHostFragment.findNavController(this@SplashFragment)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("SplashFragment", "onCreate")
        super.onCreate(savedInstanceState)

        //criando TimerTask
        val timerTask = object : TimerTask() {
            override fun run() {
                val action =
                    SplashFragmentDirections.actionSplashFragmentToReposFragment()
                navController.navigate(action)
            }
        }

        //criando Timer de 1000ms
        val timer = Timer()
        timer.schedule(timerTask, 1000)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("SplashFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}