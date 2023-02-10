package com.nexus.dictionary2.dictionaryfeature.domain.model

data class Meaning(
    val definitions: List<Definition>?,
    val speechPart: String?, // or partofSpeech
)
