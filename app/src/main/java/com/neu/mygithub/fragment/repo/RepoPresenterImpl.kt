package com.neu.mygithub.fragment.repo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.bumptech.glide.Glide
import com.neu.mygithub.MyApplication
import com.neu.mygithub.R
import com.neu.mygithub.github.model.Repo
import com.neu.mygithub.github.model.Repos.repos

/**
 * Implementação do RepoPresenter
 * @author Irineu A. Silva
 */

class RepoPresenterImpl(
    private val context: Context,
    private val repoView: RepoView /* para notificar RepoFragment */
) : RepoPresenter {

    override lateinit var repo: Repo

    override fun getRepoOfArgs(args: Bundle, setar : Boolean){
        repo = RepoFragmentArgs.fromBundle(args).repo

        if(setar)
        setRepoInfos()
    }

    override fun getUrlRepo() : Uri {
           return Uri.parse(repo.html_url)
    }

    override fun update(repoName: String, userLogin: String, description: String) {

        repo.name = repoName
        repo.owner!!.login = userLogin
        repo.description = description

        //Atualizar o full_name
        repo.full_name = repo.owner!!.login + "/" + repo.name

        val handler = Handler(Looper.getMainLooper())

        Thread {
            MyApplication.databse.repoDatabaseDao.update(repo)
            handler.post {
                repoView.collapse()
                getRepoOfStatic(repo.id)
            }
        }.start()
    }


    private fun getRepoOfStatic(id : Int)
    {
        repos.forEach {
            if(it.id == id)
            {
                setRepoInfos(it)
                return
            }
        }
    }

    private fun setRepoInfos(repo : Repo = this.repo)
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