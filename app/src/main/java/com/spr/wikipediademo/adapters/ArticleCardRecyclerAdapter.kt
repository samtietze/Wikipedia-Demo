package com.spr.wikipediademo.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.spr.wikipediademo.R
import com.spr.wikipediademo.holders.CardHolder

class ArticleCardRecyclerAdapter() : RecyclerView.Adapter<CardHolder>() {

    override fun getItemCount(): Int {
        return 15 //temp
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        var cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_card_item, parent, false)
        return CardHolder(cardItem)
    }
}