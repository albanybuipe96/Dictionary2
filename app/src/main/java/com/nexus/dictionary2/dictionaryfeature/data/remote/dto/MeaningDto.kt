package com.nexus.dictionary2.dictionaryfeature.data.remote.dto

import com.nexus.dictionary2.dictionaryfeature.domain.model.Meaning

data class MeaningDto(
    val definitions: List<DefinitionDto>?,
    val speechPart: String?
) {
    fun toMeaning(): Meaning {
        return Meaning(
            definitions = definitions?.map { it.toDefinition() },
            speechPart = speechPart
        )
    }
}