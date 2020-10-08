package com.neu.mygithub.fragment.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.neu.mygithub.R

class SplashFragment : Fragment(), SplashView {

    private lateinit var splashPresenter : SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("SplashFragment", "onCreate")
        super.onCreate(savedInstanceState)

        //Inicializando splashPresenter
        splashPresenter = SplashPresenterImpl(requireContext(), this)

        //Iniciando timer para navegar até ReposFragment
        splashPresenter.startTime()
    }
    override fun navigateToReposFragment() {
        val action =
            SplashFragmentDirections.actionSplashFragmentToReposFragment()
        findNavController().navigate(action)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("SplashFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}