package com.nexus.dictionary2.dictionaryfeature.domain.repository

import com.nexus.dictionary2.core.Resource
import com.nexus.dictionary2.dictionaryfeature.domain.model.Entry
import kotlinx.coroutines.flow.Flow

interface EntryRepository {

    fun getEntryInfo(word: String): Flow<Resource<List<Entry>>>
    
}