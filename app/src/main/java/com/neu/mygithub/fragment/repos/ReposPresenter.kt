package com.neu.mygithub.fragment.repos

/** contrato para as negras de negócio */

interface ReposPresenter {

    fun getMax(a: Int, b: Int, show : Boolean = false) : Int
}