package com.neu.mygithub.fragment.repos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.neu.mygithub.R


class ReposFragment : Fragment(), ReposView {

    //ReposPresenter's ref
    private lateinit var reposPresenter: ReposPresenter

    /**Obtém a referência do ReposPresenter implementado */
    private fun getPresenter() = ReposPresenterImpl(requireContext(), this /* ReposView */)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ReposFragment", "onCreate")

        //Inicializa propriedade reposPresenter
        reposPresenter = getPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("ReposFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_repos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("ReposFragment", "onViewCreated")
    }

    override fun showToast(msg: Any) {
        Toast.makeText(requireContext(), msg.toString(), Toast.LENGTH_SHORT).show()
    }
}