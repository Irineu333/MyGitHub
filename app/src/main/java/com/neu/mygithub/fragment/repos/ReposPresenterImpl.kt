package com.neu.mygithub.fragment.repos

import android.content.Context

/**
 * implementa as regras de negócio da interface ReposPresenter
 * e notifica pela ReposView alterações visuais */

class ReposPresenterImpl(
    private val context: Context,
    private val reposView: ReposView /*notifica ReposFragment*/
) : ReposPresenter {

    override fun getMax(a: Int, b: Int, show: Boolean): Int {
        val result = if (a > b) a else b
        if (show)
            reposView.showToast(result)
        return result
    }

}