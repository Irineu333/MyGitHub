package com.neu.mygithub.fragment.repos

import android.content.Context
import com.neu.mygithub.client.OnLoadRepos
import com.neu.mygithub.client.loadRepos
import com.neu.mygithub.github.model.Repo
import com.neu.mygithub.github.model.Repos

/**
 * implementa as regras de negócio da interface ReposPresenter
 * e notifica pela ReposView alterações visuais */

class ReposPresenterImpl(
    private val context: Context,
    private val reposView: ReposView /*notifica ReposFragment*/
) : ReposPresenter, OnLoadRepos {

    //ReposPresenter
    override fun loadRepos() {
        if (Repos.repos.isEmpty())
            loadRepos(this)
        else {
            reposView.recyclerAdapter.setRepos(Repos.repos, "static")
        }
    }

    //OnLoadRepos
    override fun onDatabaseResponse(listRepos: List<Repo>) {
        reposView.recyclerAdapter.setRepos(listRepos, "local")
        Repos.repos.addAll(listRepos)
    }

    override fun onDatabaseFailure(msg: String) {
        reposView.showToast(msg)
    }

    override fun onWebResponse(listRepos: List<Repo>) {
        reposView.recyclerAdapter.setRepos(listRepos, "web")
        Repos.repos.addAll(listRepos)
    }

    override fun onWebFailure(msg: String) {
        reposView.showToast(msg)
    }


}