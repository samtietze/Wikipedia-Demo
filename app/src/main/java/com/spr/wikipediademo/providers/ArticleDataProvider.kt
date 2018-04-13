package com.spr.wikipediademo.providers

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.spr.wikipediademo.models.Urls
import com.spr.wikipediademo.models.WikiResult
import java.io.Reader

class ArticleDataProvider {

    init{
        FuelManager.instance.baseHeaders = mapOf("User-Agent" to "Sam's Wikipedia Demo")
    }

    fun search(term: String, skip: Int, take: Int, responseHandler: (result:WikiResult) -> Unit?){
        Urls.getSearchUrl(term, skip, take).httpGet()

                .responseObject(WikipediaDataDeserializer()){ _, response, result ->
//            do something here with the handler function passed into #search
                    if(response.statusCode != 200) {
                        throw Exception("Unable to get articles")
                    }
                    val(data, _) = result
                    responseHandler.invoke(data as WikiResult)
        }
    }

    fun getRandom(take: Int, responseHandler: (result: WikiResult) -> Unit?){
        Urls.getRandomUrl(take).httpGet()
//                Underscore is an unused parameter that tells the compiler not to process it
                .responseObject(WikipediaDataDeserializer()){ _, response, result ->

                    if(response.statusCode != 200) {
                        throw Exception("Unable to get articles")
                    }
                    val(data, error) = result
                    responseHandler.invoke(data as WikiResult)

                }
    }

    class WikipediaDataDeserializer : ResponseDeserializable<WikiResult> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, WikiResult::class.java)
    }
//        This can be simplified as above
//        override fun deserialize(reader: Reader): WikiResult? {
//            return Gson().fromJson(reader, WikiResult::class.java)
//        }

}