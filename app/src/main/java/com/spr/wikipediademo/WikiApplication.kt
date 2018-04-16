package com.spr.wikipediademo

import android.app.Application
import com.spr.wikipediademo.managers.WikiManager
import com.spr.wikipediademo.providers.ArticleDataProvider
import com.spr.wikipediademo.repositories.ArticleDatabaseOpenHelper
import com.spr.wikipediademo.repositories.FavoritesRepository
import com.spr.wikipediademo.repositories.HistoryRepository

class WikiApplication: Application() {
    private var dbHelper: ArticleDatabaseOpenHelper? = null
    private var favoritesRepository: FavoritesRepository? = null
    private var historyRepository: HistoryRepository? = null
    private var wikiProvider: ArticleDataProvider? = null
    var wikiManager: WikiManager? = null
        private set

    override fun onCreate() {
        super.onCreate()

        dbHelper = ArticleDatabaseOpenHelper(applicationContext)
        favoritesRepository = FavoritesRepository(dbHelper!!)
        historyRepository = HistoryRepository(dbHelper!!)
        wikiProvider = ArticleDataProvider()
        wikiManager = WikiManager(wikiProvider!!, favoritesRepository!!, historyRepository!!)
    }
}