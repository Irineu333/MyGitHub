package com.neu.mygithub.fragment.repo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import com.bumptech.glide.Glide
import com.neu.mygithub.R
import com.neu.mygithub.github.model.Repo

/** Implementação do RepoPresenter */

class RepoPresenterImpl(
    private val context: Context,
    private val repoView: RepoView /* para notificar RepoFragment */
) : RepoPresenter {

    lateinit var repo: Repo

    override fun loadAndSetRepoOfArgs(args: Bundle) {
        repo = RepoFragmentArgs.fromBundle(args).repo
        setRepoInfos(repo)
    }

    override fun configGoToRepoUrlBtn() {
        repoView.setGoToRepoUrlOnClick {
            repoView.goToUrl(Uri.parse(repo.html_url))
        }
    }

    private fun setRepoInfos(repo : Repo)
    {
        val userLogin = repo.owner!!.login
        val repoName = repo.name

        val description = repo.description ?: "Sem descrição"
        val fullName = repo.full_name

        repoView.setRepoInfos(userLogin, repoName, description, fullName)
        loadAvatarImage(repo.owner!!.avatar_url)
    }

    private fun loadAvatarImage(url : String) {
        Glide.with(context).load(url).placeholder(R.drawable.ic_image)
            .into(repoView.avatarImageView)
    }


}