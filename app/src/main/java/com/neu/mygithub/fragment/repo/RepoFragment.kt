package com.neu.mygithub.fragment.repo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.card.MaterialCardView
import com.neu.mygithub.R
import kotlinx.android.synthetic.main.fragment_repo.*
import kotlinx.android.synthetic.main.repo_editor.*
import kotlinx.android.synthetic.main.repo_infos.*


/** Tela de apresentação do repositório
 *  @author Irineu A. Silva
 */

class RepoFragment() : Fragment(), RepoView /* para escutar RepoPresenter */ {

    //RepoPresenter's ref
    private lateinit var repoPresenter: RepoPresenter

    //from interface RepoView
    override lateinit var avatarImageView: ImageView
    override lateinit var behavior: BottomSheetBehavior<MaterialCardView>

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

        //Carregar o repositório
        repoPresenter.getRepoOfArgs(requireArguments())

        //Botões
        openBtn.setOnClickListener {
            goToUrl(repoPresenter.getUrlRepo())
        }
        configBackBtn()

        //Inicializar BottomSheetBehavior
        behavior = BottomSheetBehavior.from(bottomSheet)
        behaviorHidden()

        //OnClickListeners
        editBtn.setOnClickListener(onClick)
        closeEditorBtn.setOnClickListener(onClick)
        collapseEditorBtn.setOnClickListener(onClick)
        alterarBtn.setOnClickListener(onClick)
    }

    private fun behaviorExpanded() {
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        collapseEditorBtn.rotation = 90f
    }

    private fun behaviorHidden() {
        behavior.state = BottomSheetBehavior.STATE_HIDDEN
    }

    private fun behaviorCollapse() {
        behavior.state = BottomSheetBehavior.STATE_COLLAPSED
        collapseEditorBtn.rotation = 270f
    }

    private fun configBackBtn() {
        backBtn.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    //from interface RepoView
    override fun showToast(msg: String) {
        Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
    }

    override fun setRepoInfos(
        userLogin: String,
        repoName: String,
        description: String,
        fullName: String
    ) {
        avatarImageView = avatarImageView_Repo
        loginTextView_Repo.text = userLogin
        nameTextView_Repo.text = repoName
        this.description.text = description
        this.fullName.text = fullName
    }

    override fun goToUrl(uri: Uri) {
        startActivity(Intent(Intent.ACTION_VIEW).setData(uri))
    }

    override fun collapse() {
        val from = BottomSheetBehavior.from(bottomSheet)
        from.state = BottomSheetBehavior.STATE_HIDDEN
    }

    /** Todos os OnCLickListeners da tela
     * @author Irineu A. Silva
     */
    val onClick = View.OnClickListener {
        when (it.id) {
            R.id.collapseEditorBtn -> {
                if (behavior.state == BottomSheetBehavior.STATE_EXPANDED) {
                    behaviorCollapse()
                } else if (behavior.state == BottomSheetBehavior.STATE_COLLAPSED) {
                    behaviorExpanded()
                }
            }
            R.id.alterarBtn -> {
                val repoName = repoName_Editor.text.toString()
                val userLogin = userLogin_Editor.text.toString()
                val description = description_Editor.text.toString()

                if (repoName.isEmpty())
                    repoName_Editor.error = "Nome inválido"
                if (userLogin.isEmpty())
                    userLogin_Editor.error = "Login inválido"

                if (repoName.isNotEmpty() && userLogin.isNotEmpty())
                    repoPresenter.update(repoName, userLogin, description)
                else
                    showToast("Não foi alterado nada")
            }
            R.id.editBtn -> {
                repoName_Editor.setText(repoPresenter.repo.name)
                userLogin_Editor.setText(repoPresenter.repo.owner?.login)
                description_Editor.setText(repoPresenter.repo.description)
                behaviorExpanded()
            }
            R.id.closeEditorBtn -> {
                behaviorHidden()
            }
        }
    }

}