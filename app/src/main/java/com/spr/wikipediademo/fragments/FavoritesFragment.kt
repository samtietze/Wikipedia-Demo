package com.spr.wikipediademo.fragments

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.spr.wikipediademo.R
import com.spr.wikipediademo.WikiApplication
import com.spr.wikipediademo.adapters.ArticleCardRecyclerAdapter
import com.spr.wikipediademo.managers.WikiManager
import kotlinx.android.synthetic.main.fragment_favorites.*

class FavoritesFragment : Fragment() {

    private var wikiManager: WikiManager? = null
    var favoritesRecycler: RecyclerView? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        wikiManager = (activity?.applicationContext as WikiApplication).wikiManager
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_favorites, container, false)

        favoritesRecycler = view.findViewById<RecyclerView>(R.id.favorites_article_recycler)
        favoritesRecycler!!.layoutManager = LinearLayoutManager(context)
        favoritesRecycler!!.adapter = ArticleCardRecyclerAdapter()

        return view
    }
}