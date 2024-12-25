package com.example.messagingui.messagingUI

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.messagingui.MessageVM
import com.example.messagingui.R

@Composable

fun Messaging() {
    val viewModel: MessageVM = viewModel()
    MaterialTheme {
        Conversation(
            modifier = Modifier.fillMaxSize(),
            state = viewModel.uiState.collectAsState().value
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(modifier: Modifier = Modifier,onClose:()->Unit) {
    TopAppBar(modifier = modifier, title = {Text(text = stringResource(id = R.string.app_name))}, navigationIcon = {
        IconButton(onClick = {onClose()}) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(id = R.string.cd_close_conversation)
            )
        }
    })

}
@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    Header(modifier = Modifier.fillMaxSize(),onClose = {})
}

