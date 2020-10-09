package com.neu.mygithub.fragment.repo

import android.os.Bundle

/** interface das regras de negócio */

interface RepoPresenter {
    fun loadAndSetRepoOfArgs(args : Bundle)
    fun configGoToRepoUrlBtn()
}