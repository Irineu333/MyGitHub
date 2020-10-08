package com.neu.mygithub.client

import android.util.Log
import com.neu.mygithub.github.GitHubService
import com.neu.mygithub.github.model.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WebClient(baseUrl: String = "https://api.github.com/") {

    private val service: GitHubService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(GitHubService::class.java)
    }

    fun listPublic(onLoadRepos: OnLoadRepos) {
        val call: Call<List<Repo>> = service.listPublic()
        call.enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                val body = response.body()
                if (body != null) {
                    Log.d("Retrofit", "Total: ${body.size}")
                    onLoadRepos.onWebResponse(body)

                    //Atualizar database
                    DatabaseClient.insertAll(body)
                } else {
                    onLoadRepos.onWebFailure(response.message())
                }
            }
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                onLoadRepos.onWebFailure(t.message.toString())
            }
        })
    }
}