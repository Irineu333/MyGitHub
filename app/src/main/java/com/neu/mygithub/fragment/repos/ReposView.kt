package com.neu.mygithub.fragment.repos

/**
 * interface entre ReposFragment e ReposPresenterImpl
 * para notificação de alterações visuais */

interface ReposView {

    fun showToast(msg : Any)
}