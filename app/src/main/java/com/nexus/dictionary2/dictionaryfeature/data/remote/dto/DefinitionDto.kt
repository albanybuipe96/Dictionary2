package com.nexus.dictionary2.dictionaryfeature.data.remote.dto

import com.nexus.dictionary2.dictionaryfeature.domain.model.Definition

data class DefinitionDto(
    val antonyms: List<String>?,
    val definition: String?,
    val example: String?,
    val synonyms: List<String>?
) {
    fun toDefinition(): Definition {
        return Definition(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}