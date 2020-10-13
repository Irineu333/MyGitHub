package com.neu.mygithub.client

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.neu.mygithub.MyApplication
import com.neu.mygithub.github.model.Repo


/** Classe que controla as solicitações ao database local com Room
 *  @author Irineu A. Silva
 */

class DatabaseClient {

    companion object {
        fun load(onLoadRepos: OnLoadRepos) {
            Thread {
                val handler = Handler(Looper.getMainLooper())

                val listRepos: MutableList<Repo> = mutableListOf()
                val repoAll = MyApplication.databse.repoDatabaseDao.getRepoAll()

                if (repoAll.isNullOrEmpty()) {
                    handler.post {
                        onLoadRepos.onDatabaseFailure("Sem dados locais")
                    }
                } else {


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
                    MyApplication.databse.repoDatabaseDao.insert(it, it.owner!! /* nulidade improvável */)
                }
                Log.d("insertAll", "Total ${listaRepos.size}")
            }.start()
        }

        fun getRepoAtId(id : Int, onLocalLoad: OnLocalLoad) {
            Thread {
                val repo = MyApplication.databse.repoDatabaseDao.getRepoAtId(id)
                if(repo == null)
                {
                    onLocalLoad.onFail("Repositório não encontrado")
                } else {
                    val fullName = repo.full_name
                    val login = fullName.substring(0, fullName.indexOf("/"))
                    repo.owner = MyApplication.databse.repoDatabaseDao.getOwner(login)

                    onLocalLoad.onLoad(repo)
                }
            }.start()
        }
    }

    /** interface para notificação de falha ou êxito
     *  @author Irineu A. Silva
     */

    interface OnLocalLoad
    {
        fun onLoad(repo : Repo)
        fun onFail(msg : String)
    }
}