package com.neu.mygithub.github

import com.neu.mygithub.github.model.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    /** obtém repositórios públicos, qtd = 100 */
    @GET("/repositories")
    fun listPublic() : Call<List<Repo>>

    /** obtém linguagens usadas no repositório */
    @GET("/repos/{login}/{name}/languages")
    fun listLanguages(@Path("login") login : String, @Path("name") name : String) : Call<HashMap<String, Any>>
}