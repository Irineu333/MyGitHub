package com.neu.mygithub.fragment.repo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.neu.mygithub.R
import kotlinx.android.synthetic.main.fragment_repo.*
import kotlinx.android.synthetic.main.repo_infos.*

class RepoFragment() : Fragment(), RepoView /* para escutar RepoPresenter */ {

    //RepoPresenter's ref
    private lateinit var repoPresenter: RepoPresenter

    //from interface RepoView
    override lateinit var avatarImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializa repoPresenter
        repoPresenter = RepoPresenterImpl(requireContext(), this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        repoPresenter.loadAndSetRepoOfArgs(requireArguments())
        repoPresenter.configGoToRepoUrlBtn()
        configBackBtn()
    }

    private fun configBackBtn() {
        //Isso é uma regra de negócio??
        backImageView.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("RepoFragment", "onActivityCreated")
    }

    //from interface RepoView
    override fun showToast(msg : String)
    {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun setRepoInfos(userLogin : String, repoName : String, description: String, fullName : String) {
        avatarImageView = avatarImageView_Repo
        loginTextView_Repo.text = userLogin
        nameTextView_Repo.text = repoName
        this.description.text = description
        this.fullName.text = fullName
    }

    override fun goToUrl(uri: Uri) {
        startActivity(Intent(Intent.ACTION_VIEW).setData(uri))
    }

    override fun setGoToRepoUrlOnClick(listener: View.OnClickListener) {
        openImageView.setOnClickListener(listener)
    }

}