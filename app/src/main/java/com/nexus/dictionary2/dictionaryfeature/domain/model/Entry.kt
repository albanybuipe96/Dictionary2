package com.nexus.dictionary2.dictionaryfeature.domain.model

data class Entry(
    val meanings: List<Meaning>?,
    val origin: String?,
    val phonetic: String?,
    val word: String?,
)
