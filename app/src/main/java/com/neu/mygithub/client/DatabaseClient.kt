package com.neu.mygithub.client

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.neu.mygithub.MyApplication
import com.neu.mygithub.github.model.Repo

class DatabaseClient {

    companion object {
        fun load(onLoadRepos: OnLoadRepos) {
            Thread {

                val listRepos: MutableList<Repo> = mutableListOf()
                val repoAll = MyApplication.databse.repoDatabaseDao.getRepoAll()

                if (repoAll != null && repoAll.isNotEmpty()) {
                    val handler = Handler(Looper.getMainLooper())
                    repoAll.forEach {
                        val fullName = it.full_name
                        it.owner = MyApplication.databse.repoDatabaseDao.getOwner(
                            fullName.substring(
                                0,
                                fullName.indexOf("/")
                            )
                        )
                        listRepos.add(it)
                    }
                    handler.post {
                        onLoadRepos.onDatabaseResponse(listRepos)
                    }

                } else {
                    onLoadRepos.onDatabaseFailure("Database vazio")
                }
            }.start()
        }

        fun insertAll(listaRepos: List<Repo>) {
            Thread {
                listaRepos.forEach {
                    MyApplication.databse.repoDatabaseDao.insert(it, it.owner!!)
                }
                Log.d("insertAll", "Total ${listaRepos.size}")
            }.start()
        }
    }
}