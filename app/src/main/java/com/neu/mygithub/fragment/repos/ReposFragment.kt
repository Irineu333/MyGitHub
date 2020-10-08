package com.neu.mygithub.fragment.repos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.neu.mygithub.R
import com.neu.mygithub.adapter.RecyclerAdapter
import com.neu.mygithub.github.model.Repo
import kotlinx.android.synthetic.main.fragment_repos.*


class ReposFragment() : Fragment(), ReposView, RecyclerAdapter.OnClickListener {

    //ReposPresenter's ref
    private lateinit var reposPresenter: ReposPresenter

    //Propriedades do ReposView
    override lateinit var recyclerAdapter: RecyclerAdapter

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

        reposPresenter.loadRepos()

        return inflater.inflate(R.layout.fragment_repos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("ReposFragment", "onViewCreated")

        //Inicializa o adapter e seta no RecyclerView
        recyclerAdapter = RecyclerAdapter(requireContext(), onClickListener = this)
        recyclerView.adapter = recyclerAdapter
        //
    }

    override fun showToast(msg: Any) {
        Toast.makeText(requireContext(), msg.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onClick(data: Repo) {
        //
    }
}