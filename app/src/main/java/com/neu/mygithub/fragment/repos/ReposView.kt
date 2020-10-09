package com.neu.mygithub.fragment.repos

import com.neu.mygithub.adapter.RecyclerAdapter

/**
 * interface entre ReposFragment e ReposPresenterImpl
 * para notificação de alterações visuais */

interface ReposView {
    //Variáveis
    val recyclerAdapter : RecyclerAdapter
    //Funções
    fun showToast(msg : Any)
}