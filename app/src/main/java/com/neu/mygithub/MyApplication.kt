package com.neu.mygithub

import android.app.Application
import com.facebook.stetho.Stetho
import com.neu.mygithub.client.database.RepoDatabase

class MyApplication : Application() {
    companion object {
        lateinit var databse : RepoDatabase
    }

    override fun onCreate() {
        super.onCreate()

        //Obtendo instância de RepoDatabase implementada pelo RoomDatabase
        databse = RepoDatabase.getInstance(this)

        //Iniciando Stetho
        val builder = Stetho.newInitializerBuilder(this)
        builder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
        val initializer = builder.build()
        Stetho.initialize(initializer)
    }

}