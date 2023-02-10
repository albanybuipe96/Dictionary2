package com.nexus.dictionary2.dictionaryfeature.domain.usecases

import com.nexus.dictionary2.core.Resource
import com.nexus.dictionary2.dictionaryfeature.domain.model.Entry
import com.nexus.dictionary2.dictionaryfeature.domain.repository.EntryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetEntryInfoUseCase(private val repository: EntryRepository) {

    operator fun invoke(word: String): Flow<Resource<List<Entry>>> {
        if (word.isBlank()) {
            return flow {  }
        }
        return repository.getEntryInfo(word)
    }

}