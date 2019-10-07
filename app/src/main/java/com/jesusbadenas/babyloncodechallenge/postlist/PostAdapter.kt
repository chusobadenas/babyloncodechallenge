package com.jesusbadenas.babyloncodechallenge.postlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.jesusbadenas.babyloncodechallenge.R
import com.jesusbadenas.babyloncodechallenge.di.ApplicationContext
import com.jesusbadenas.babyloncodechallenge.entities.Post
import javax.inject.Inject

class PostAdapter
@Inject
constructor(@ApplicationContext context: Context) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    interface OnItemClickListener {
        fun onPostItemClicked(post: Post)
    }

    private var posts: List<Post> = emptyList()
    private val layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private var onItemClickListener: OnItemClickListener? = null

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = layoutInflater.inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.textViewTitle.text = post.title
        holder.itemView.setOnClickListener {
            onItemClickListener?.onPostItemClicked(post)
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun setPosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.post_title)
        lateinit var textViewTitle: TextView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}
