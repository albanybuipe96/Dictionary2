package com.nexus.dictionary2.dictionaryfeature.data.repository

import com.nexus.dictionary2.core.Resource
import com.nexus.dictionary2.dictionaryfeature.data.remote.DictionaryAPI
import com.nexus.dictionary2.dictionaryfeature.domain.model.Entry
import com.nexus.dictionary2.dictionaryfeature.domain.repository.EntryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class EntryRepositoryImpl(private val api: DictionaryAPI) : EntryRepository {
    override fun getEntryInfo(word: String): Flow<Resource<List<Entry>>> = flow {
        emit(Resource.Loading())

        try {
            val remoteEntry = api.getEntryInfo(word)
            emit(Resource.Success(data = remoteEntry.map { it.toEntity() }))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Ooooops, something went wrong.", data = emptyList()))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Server couldn't be reached. Check internet connection.", data = emptyList()))
        }

    }
}