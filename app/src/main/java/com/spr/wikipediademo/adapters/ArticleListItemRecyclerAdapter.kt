package com.spr.wikipediademo.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.spr.wikipediademo.R
import com.spr.wikipediademo.holders.ListItemHolder

class ArticleListItemRecyclerAdapter() : RecyclerView.Adapter<ListItemHolder>() {

    override fun getItemCount(): Int {
        return 15 //temp
    }

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        var cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_list_item, parent, false)
        return ListItemHolder(cardItem)
    }
}