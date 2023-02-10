package com.nexus.dictionary2.dictionaryfeature.data.remote

import com.nexus.dictionary2.dictionaryfeature.data.remote.dto.EntryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryAPI {

    @GET("/api/v2/entries/en/{word}")
    suspend fun getEntryInfo(@Path("word") word: String): List<EntryDto>

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev"
    }

}