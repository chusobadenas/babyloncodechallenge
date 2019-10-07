package com.jesusbadenas.babyloncodechallenge.postdetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.jesusbadenas.babyloncodechallenge.R
import com.jesusbadenas.babyloncodechallenge.common.BaseMvpFragment
import javax.inject.Inject

class PostDetailsFragment : BaseMvpFragment(), PostDetailsMvpView {

    @Inject
    lateinit var postDetailsPresenter: PostDetailsPresenter

    @BindView(R.id.tv_title)
    lateinit var textViewTitle: TextView
    @BindView(R.id.tv_author)
    lateinit var textViewAuthor: TextView
    @BindView(R.id.tv_comments)
    lateinit var textViewComments: TextView
    @BindView(R.id.tv_body)
    lateinit var textViewBody: TextView
    @BindView(R.id.rl_progress)
    lateinit var viewProgress: RelativeLayout
    @BindView(R.id.rl_retry)
    lateinit var viewRetry: RelativeLayout
    @BindView(R.id.post_detail_view)
    lateinit var viewPostDetail: LinearLayout

    private var unbinder: Unbinder? = null

    companion object {
        fun newInstance(): PostDetailsFragment {
            return PostDetailsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentView = inflater.inflate(R.layout.fragment_post_details, container, false)
        unbinder = ButterKnife.bind(this, fragmentView)
        postDetailsPresenter.attachView(this)
        return fragmentView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unbinder?.unbind()
    }

    override fun onAttachToContext(context: Context) {
        // nothing to do
    }

    override fun onStart() {
        super.onStart()
        loadPostDetails()
    }

    override fun onDestroy() {
        super.onDestroy()
        postDetailsPresenter.detachView()
    }

    override fun showPostDetails(name: String, nComments: Long) {
        val pdActivity: PostDetailsActivity = activity as PostDetailsActivity
        textViewTitle.text = pdActivity.postTitle
        textViewAuthor.text = name
        textViewComments.text = nComments.toString()
        textViewBody.text = pdActivity.postBody
    }

    override fun showLoading() {
        viewPostDetail.visibility = View.GONE
        viewProgress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        viewPostDetail.visibility = View.VISIBLE
        viewProgress.visibility = View.GONE
    }

    override fun showRetry() {
        viewRetry.visibility = View.VISIBLE
    }

    override fun hideRetry() {
        viewRetry.visibility = View.GONE
    }

    private fun loadPostDetails() {
        val pdActivity: PostDetailsActivity = activity as PostDetailsActivity
        postDetailsPresenter.initialize(pdActivity.postId, pdActivity.userId)
    }

    @OnClick(R.id.bt_retry)
    fun onButtonRetryClick() {
        loadPostDetails()
    }
}
