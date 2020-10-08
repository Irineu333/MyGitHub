package com.neu.mygithub.client

import com.neu.mygithub.github.model.Repo

fun loadRepos(onLoadRepos: OnLoadRepos)
{
    //Carregar dados locais
    DatabaseClient.load(onLoadRepos)

    //Carregar dados online
    val web = WebClient()
    web.listPublic(onLoadRepos)
}

interface OnLoadRepos {
    fun onDatabaseResponse(listRepos: List<Repo>)
    fun onWebResponse(listRepos : List<Repo>)
    fun onDatabaseFailure(msg: String)
    fun onWebFailure(msg : String)
}