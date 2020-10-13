package com.neu.mygithub.fragment.repo

import android.net.Uri
import android.widget.ImageView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.card.MaterialCardView

/**
 * interface de comunicação visual com RepoFragment
 * @author Irineu A. Silva
 */

interface RepoView {
    var avatarImageView: ImageView
    var behavior: BottomSheetBehavior<MaterialCardView>
    fun showToast(msg: String)
    fun setRepoInfos(userLogin: String, repoName: String, description: String, fullName : String)
    fun goToUrl(uri : Uri)
    fun collapse()
}