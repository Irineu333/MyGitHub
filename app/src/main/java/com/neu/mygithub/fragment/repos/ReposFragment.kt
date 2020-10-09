package com.neu.mygithub.fragment.repos

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.neu.mygithub.R
import com.neu.mygithub.adapter.RecyclerAdapter
import com.neu.mygithub.github.model.Repo
import kotlinx.android.synthetic.main.fragment_repos.*

/** Tela de repositórios públicos
 *  @author Irineu A. Silva
 */

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

        //Inicializar propriedade reposPresenter
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

        //Inicializa o adapter e seta no RecyclerView
        recyclerAdapter = RecyclerAdapter(requireContext(), onClickListener = this)
        recyclerView.adapter = recyclerAdapter

        //Carregar os repositórios
        reposPresenter.loadRepos()
    }

    //ReposView
    override fun showToast(msg: Any) {
        Toast.makeText(requireContext(), msg.toString(), Toast.LENGTH_SHORT).show()
    }

    //RecyclerAdapter.OnClickListener
    override fun onClick(repo: Repo) {
        val action =
            ReposFragmentDirections.actionReposFragmentToRepoFragment(repo)
        findNavController().navigate(action)
    }
}