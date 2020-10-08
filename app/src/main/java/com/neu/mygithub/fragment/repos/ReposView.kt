package com.neu.mygithub.fragment.repos

import com.neu.mygithub.adapter.RecyclerAdapter

/**
 * interface entre ReposFragment e ReposPresenterImpl
 * para notificação de alterações visuais */

interface ReposView {
    val recyclerAdapter : RecyclerAdapter
    fun showToast(msg : Any)
}