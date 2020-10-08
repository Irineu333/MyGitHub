package com.neu.mygithub.client

import com.neu.mygithub.github.model.Repo

fun loadRepos(onLoadRepos: OnLoadRepos)
{
//    val database = DatabaseClient()
//    database.start(OnLoadRepos)

    val web = WebClient()
    web.listPublic(onLoadRepos)
}

interface OnLoadRepos {
    fun onDatabaseResponse(listRepos: List<Repo>)
    fun onWebResponse(listRepos : List<Repo>)
    fun onWebFailure(msg : String)
}