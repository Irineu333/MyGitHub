package com.neu.mygithub.fragment.splash

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.neu.mygithub.R

/**
 * pseudo tela de carregamento anterior a tela de repositórios, ReposFragment /
 * @author Irineu A. Silva
 */

class SplashFragment : Fragment(), SplashView {

    //SplashPresenter's ref
    private lateinit var splashPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("SplashFragment", "onCreate")
        super.onCreate(savedInstanceState)

        //Inicializando splashPresenter
        splashPresenter = SplashPresenterImpl(requireContext(), this)

        //Iniciando timer para navegar até ReposFragment
        splashPresenter.startTime()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("SplashFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    //SplashView
    override fun navigateToReposFragment() {
        /** Navega para ReposFragment*/
        val action =
            SplashFragmentDirections.actionSplashFragmentToReposFragment()
        findNavController().navigate(action)
    }


}