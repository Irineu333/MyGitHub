package com.neu.mygithub.fragment.repos

import android.content.Context
import com.neu.mygithub.client.OnLoadRepos
import com.neu.mygithub.client.loadRepos
import com.neu.mygithub.github.model.Repo

/**
 * implementa as regras de negócio da interface ReposPresenter
 * e notifica pela ReposView alterações visuais */

class ReposPresenterImpl(
    private val context: Context,
    private val reposView: ReposView /*notifica ReposFragment*/
) : ReposPresenter, OnLoadRepos {

    //ReposPresenter
    override fun loadRepos() {
        loadRepos(this)
    }

    //OnLoadRepos
    override fun onDatabaseResponse(listRepos: List<Repo>) {
        reposView.recyclerAdapter.setRepos(listRepos, "database")

    }

    override fun onWebResponse(listRepos: List<Repo>) {
        reposView.recyclerAdapter.setRepos(listRepos, "web")
    }

    override fun onDatabaseFailure(msg: String) {
        reposView.showToast(msg)
    }

    override fun onWebFailure(msg: String) {
        reposView.showToast(msg)
    }


}