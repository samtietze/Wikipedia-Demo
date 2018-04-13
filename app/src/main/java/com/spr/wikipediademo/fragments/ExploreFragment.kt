package com.spr.wikipediademo.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.spr.wikipediademo.R
import com.spr.wikipediademo.activities.SearchActivity
import com.spr.wikipediademo.adapters.ArticleCardRecyclerAdapter
import com.spr.wikipediademo.providers.ArticleDataProvider


/**
 * A simple [Fragment] subclass.
 *
 */
class ExploreFragment : Fragment() {

    private val articleProvider: ArticleDataProvider = ArticleDataProvider()
    var searchCardView: CardView? = null
    var exploreRecycler: RecyclerView? = null
    var adapter: ArticleCardRecyclerAdapter = ArticleCardRecyclerAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_explore, container, false)

        searchCardView = view.findViewById<CardView>(R.id.search_card_view)
        exploreRecycler = view.findViewById<RecyclerView>(R.id.explore_article_recycler)

        searchCardView!!.setOnClickListener{
            val searchIntent = Intent(context, SearchActivity::class.java)
            context?.startActivity(searchIntent)
        }

        exploreRecycler!!.layoutManager = LinearLayoutManager(context)
        exploreRecycler!!.adapter = adapter

        return view
    }

    private fun getRandomArticles(){
        articleProvider.getRandom(15, { wikiResult ->
            // do something with articles
            adapter.currentResults.clear()
            adapter.currentResults.addAll(wikiResult.query!!.pages)
            activity!!.runOnUiThread { adapter.notifyDataSetChanged() }
        })
    }


}
