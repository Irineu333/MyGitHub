package com.neu.mygithub.fragment.repo

import android.net.Uri
import android.view.View
import android.widget.ImageView

/** interface de comunicação visual com RepoFragment */

interface RepoView {
    var avatarImageView: ImageView
    fun showToast(msg: String)
    fun setRepoInfos(userLogin: String, repoName: String, description: String, fullName : String)
    fun goToUrl(uri : Uri)
    fun setGoToRepoUrlOnClick(onClickListener: View.OnClickListener)
}