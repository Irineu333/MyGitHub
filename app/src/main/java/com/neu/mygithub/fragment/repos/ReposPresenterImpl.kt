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
) : ReposPresenter,OnLoadRepos {

    override fun loadRepos() {
        loadRepos(this)
    }

    override fun onDatabaseResponse(listRepos: List<Repo>) {
        reposView.recyclerAdapter.setRepos(listRepos, "database")
    }

    override fun onWebResponse(listRepos: List<Repo>) {
        reposView.recyclerAdapter.setRepos(listRepos, "web")
    }

    override fun onWebFailure(msg: String) {
        reposView.showToast(msg)
    }


}