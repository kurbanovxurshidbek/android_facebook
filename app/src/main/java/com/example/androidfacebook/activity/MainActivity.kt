package com.example.androidfacebook.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfacebook.R
import com.example.androidfacebook.adapter.FeedAdapter
import com.example.androidfacebook.model.Feed
import com.example.androidfacebook.model.Post
import com.example.androidfacebook.model.Story

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))

        refreshAdapter(getAllFeeds())
    }

    fun refreshAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        recyclerView!!.adapter = adapter
    }

    fun getAllFeeds(): ArrayList<Feed> {
        val stories: ArrayList<Story> = ArrayList<Story>()
        stories.add(Story(R.drawable.im_user_1, "Xurshidbek Kurbanov"))
        stories.add(Story(R.drawable.im_user_2, "Begzodbek Kurbanov"))
        stories.add(Story(R.drawable.im_user_3, "Sherzodbek Kurbanov"))
        stories.add(Story(R.drawable.im_user_1, "Xurshidbek Kurbanov"))
        stories.add(Story(R.drawable.im_user_2, "Begzodbek Kurbanov"))
        stories.add(Story(R.drawable.im_user_3, "Sherzodbek Kurbanov"))

        val feeds: ArrayList<Feed> = ArrayList<Feed>()
        //Head
        feeds.add(Feed())
        //Story
        feeds.add(Feed(stories))
        //Post
        feeds.add(Feed(Post(R.drawable.im_user_2, "Xurshidbek", R.drawable.im_post_4)))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Xurshidbek", R.drawable.im_post_3)))
        feeds.add(Feed(Post(R.drawable.im_user_3, "Xurshidbek", R.drawable.im_post_2)))
        feeds.add(Feed(Post(R.drawable.im_user_1, "Xurshidbek", R.drawable.im_post_1)))
        return feeds
    }
}