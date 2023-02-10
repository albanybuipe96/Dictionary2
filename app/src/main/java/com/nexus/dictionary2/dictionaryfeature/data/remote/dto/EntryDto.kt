package com.nexus.dictionary2.dictionaryfeature.data.remote.dto

import com.nexus.dictionary2.dictionaryfeature.domain.model.Entry

data class EntryDto(
    val meanings: List<MeaningDto>?,
    val origin: String?,
    val phonetic: String?,
    val word: String?
) {
    fun toEntity(): Entry {
        return Entry(
            meanings = meanings?.map { it.toMeaning() },
            origin = origin,
            phonetic = phonetic,
            word = word
        )
    }
}
