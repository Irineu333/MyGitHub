package com.neu.mygithub.client.database

import androidx.room.*
import com.neu.mygithub.github.model.Repo

@Dao
interface RepoDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(repository: Repo, owner: Repo.Owner)

    @Query("SELECT * FROM repository_table")
    fun getRepoAll(): List<Repo>?

    @Query("SELECT * from repository_table WHERE id = :id")
    fun getRepoAtId(id : Int): Repo?

    @Query("SELECT * from author_table WHERE login = :login")
    fun getOwner(login : String): Repo.Owner?

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(repo : Repo)
}