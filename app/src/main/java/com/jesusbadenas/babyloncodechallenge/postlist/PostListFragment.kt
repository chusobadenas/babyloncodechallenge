package com.jesusbadenas.babyloncodechallenge.postlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.jesusbadenas.babyloncodechallenge.R
import com.jesusbadenas.babyloncodechallenge.common.BaseMvpFragment
import com.jesusbadenas.babyloncodechallenge.entities.Post
import javax.inject.Inject

class PostListFragment : BaseMvpFragment(), PostListMvpView {

    @Inject
    lateinit var postListPresenter: PostListPresenter
    @Inject
    lateinit var postAdapter: PostAdapter

    @BindView(R.id.rv_posts)
    lateinit var viewPosts: RecyclerView
    @BindView(R.id.rl_progress)
    lateinit var viewProgress: RelativeLayout
    @BindView(R.id.rl_retry)
    lateinit var viewRetry: RelativeLayout
    @BindView(R.id.swipe_container)
    lateinit var swipeRefresh: SwipeRefreshLayout

    private var postListListener: PostListListener? = null
    private var unbinder: Unbinder? = null

    companion object {
        fun newInstance(): PostListFragment {
            return PostListFragment()
        }
    }

    private val onItemClickListener = object : PostAdapter.OnItemClickListener {
        override fun onPostItemClicked(post: Post) {
            postListPresenter.onPostClicked(post)
        }
    }

    interface PostListListener {
        fun onPostClicked(post: Post)
    }

    override fun onAttachToContext(context: Context) {
        if (context is PostListListener) {
            postListListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentView = inflater.inflate(R.layout.fragment_post_list, container, false)
        unbinder = ButterKnife.bind(this, fragmentView)
        postListPresenter.attachView(this)
        setupRecyclerView()
        return fragmentView
    }

    override fun onStart() {
        super.onStart()
        loadPostList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewPosts.adapter = null
        unbinder?.unbind()
    }

    override fun onDestroy() {
        super.onDestroy()
        postListPresenter.detachView()
    }

    override fun showLoading() {
        swipeRefresh.visibility = View.GONE
        swipeRefresh.isRefreshing = true
        viewProgress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        swipeRefresh.visibility = View.VISIBLE
        swipeRefresh.isRefreshing = false
        viewProgress.visibility = View.GONE
    }

    override fun showRetry() {
        viewRetry.visibility = View.VISIBLE
    }

    override fun hideRetry() {
        viewRetry.visibility = View.GONE
    }

    override fun showPosts(posts: List<Post>) {
        postAdapter.setPosts(posts)
    }

    override fun viewPost(post: Post) {
        if (postListListener != null) {
            postListListener?.onPostClicked(post)
        }
    }

    private fun setupRecyclerView() {
        postAdapter.setOnItemClickListener(onItemClickListener)
        viewPosts.layoutManager = PostLayoutManager(context())
        viewPosts.adapter = postAdapter

        swipeRefresh.setColorSchemeResources(R.color.primary)
        swipeRefresh.setOnRefreshListener {
            loadPostList()
        }
    }

    private fun loadPostList() {
        postListPresenter.initialize()
    }

    @OnClick(R.id.bt_retry)
    fun onButtonRetryClick() {
        loadPostList()
    }
}
