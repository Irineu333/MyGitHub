package com.neu.mygithub.fragment.repo

import android.net.Uri
import android.os.Bundle
import com.neu.mygithub.github.model.Repo

/**
 * interface das regras de negócio
 * @author Irineu A. Silva
 */

interface RepoPresenter {
    var repo: Repo
    fun getRepoOfArgs(args : Bundle, setar : Boolean = true)
    fun getUrlRepo() : Uri
    fun update(repoName : String, userLogin : String, description: String)
}