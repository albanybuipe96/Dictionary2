package com.nexus.dictionary2.dictionaryfeature.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nexus.dictionary2.dictionaryfeature.domain.model.Entry

@Composable
fun EntryCard(entry: Entry, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = entry.word ?: "", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.Black)
        Text(text = entry.phonetic ?: "", fontWeight = FontWeight.Light)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = entry.origin ?: "")

        entry.meanings?.forEach {
            Text(text = it.speechPart ?: "", fontWeight = FontWeight.Bold)
            it.definitions?.forEachIndexed { index, definition ->
                Text(text = "${index + 1}. ${definition.definition}")
                Spacer(modifier = Modifier.height(8.dp))
                definition.example?.let { example ->
                    Text(text = "E.g. $example")
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}