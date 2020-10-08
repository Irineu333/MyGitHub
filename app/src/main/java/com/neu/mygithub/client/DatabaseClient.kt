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

                if (repoAll.isNullOrEmpty()) {
                    onLoadRepos.onDatabaseFailure("Database vazio")

                } else {

                    val handler = Handler(Looper.getMainLooper())
                    repoAll.forEach {
                        val fullName = it.full_name
                        val login = fullName.substring(0, fullName.indexOf("/"))
                        it.owner = MyApplication.databse.repoDatabaseDao.getOwner(login)
                        listRepos.add(it)
                    }
                    handler.post {
                        onLoadRepos.onDatabaseResponse(listRepos)
                    }
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