package com.neu.mygithub.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neu.mygithub.R
import com.neu.mygithub.github.model.Repo

class RecyclerAdapter(
    private val context: Context,
    private var listRepos: MutableList<Repo> = mutableListOf(),
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<RecyclerAdapter.MyHolder>() {

    var origem = ""

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView : TextView = itemView.findViewById(R.id.nameTextView)
        private val loginTextView : TextView = itemView.findViewById(R.id.loginTextView)
        private val origemTextView : TextView = itemView.findViewById(R.id.originTextView)
        val avatarImageView : ImageView = itemView.findViewById(R.id.avatarImageView)

        fun atualiza(userLogin: String, repoName : String, origem: String)
        {
            loginTextView.text = userLogin
            nameTextView.text = repoName
            origemTextView.text = origem
        }
    }

    fun setRepos(listRepos : List<Repo>, origem : String = "")
    {
        this.listRepos = listRepos.toMutableList()
        Log.d("RecyclerAdapter", "setRepos $origem, count ${listRepos.size}")
        this.origem = origem
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        //objects
        val repo = listRepos[position]
        val author = repo.owner

        //strings
        val repoName = repo.name
        val userLogin = author?.login ?: "nulo"

        //configura MyHolder
        holder.atualiza(repoName, userLogin, origem)

        //avatar
        Glide.with(context).load(repo.owner?.avatar_url).placeholder(R.drawable.ic_imagem)
            .into(holder.avatarImageView)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(repo)
        }
    }

    override fun getItemCount(): Int {
        return listRepos.size
    }

    interface OnClickListener {
        fun onClick(data: Repo)
    }
}