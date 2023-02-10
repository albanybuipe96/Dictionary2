package com.nexus.dictionary2.dictionaryfeature.presentation

import com.nexus.dictionary2.dictionaryfeature.domain.model.Entry

data class EntryState(
    val entries: List<Entry> = emptyList(),
    val isLoading: Boolean = false
)