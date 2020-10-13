package com.neu.mygithub.client.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.neu.mygithub.github.model.Repo

@Database(entities = [Repo::class, Repo.Owner::class], version = 2, exportSchema = false)
abstract class RepoDatabase : RoomDatabase(){
    abstract val repoDatabaseDao : RepoDatabaseDao
    companion object {
        @Volatile
        private var instance: RepoDatabase? = null

        /** Inicialização do banco de dados
         *  @author Irineu A. Silva
         */
        fun getInstance(context : Context) : RepoDatabase
        {
            synchronized(this) /* para evitar mais de uma instanciação */ {
                var instance = instance

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RepoDatabase::class.java,
                        "repos-db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    this.instance = instance
                }
                return instance
            }
        }
    }
}