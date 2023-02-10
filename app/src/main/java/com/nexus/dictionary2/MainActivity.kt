package com.nexus.dictionary2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.nexus.dictionary2.dictionaryfeature.presentation.EntryCard
import com.nexus.dictionary2.dictionaryfeature.presentation.EntryViewModel
import com.nexus.dictionary2.ui.theme.Dictionary2Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dictionary2Theme {
                val viewModel: EntryViewModel = hiltViewModel()
                val state = viewModel.state.value
                val scaffoldState = rememberScaffoldState()

                LaunchedEffect(key1 = true) {
                    viewModel.eventFlow.collectLatest { event ->
                        when (event) {
                            is EntryViewModel.UIEvent.ShowSnackbar -> {
                                scaffoldState.snackbarHostState.showSnackbar(message = event.message)
                            }
                        }
                    }
                } // end LaunchedEffect
                Scaffold(scaffoldState = scaffoldState) {
                    Box(modifier = Modifier.background(MaterialTheme.colors.background)) {
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)) {
                            TextField(
                                value = viewModel.searchQuery.value,
                                onValueChange = viewModel::onSearch,
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text(text = "Search")
                                }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            LazyColumn(modifier = Modifier.fillMaxSize()) {
                                items(state.entries.size) { i ->
                                    val entry = state.entries[i]
                                    if (i > 0) {
                                        Spacer(modifier = Modifier.height(8.dp))
                                    }
                                    EntryCard(entry = entry)
                                    if (i < state.entries.size - 1) {
                                        Divider()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}