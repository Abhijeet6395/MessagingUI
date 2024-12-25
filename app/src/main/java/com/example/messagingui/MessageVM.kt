package com.example.messagingui

import androidx.lifecycle.ViewModel
import com.example.messagingui.constants.ConversationEvent
import com.example.messagingui.constants.MessageDirection
import com.example.messagingui.dataClass.ConversationState
import com.example.messagingui.dataClass.Message
import kotlinx.coroutines.flow.MutableStateFlow

class MessageVM:ViewModel() {
    val uiState= MutableStateFlow(ConversationState())

    private fun buildMessage(message:String):Message{
        return Message(
            uiState.value.messages.count().toString(),
            MessageDirection.SENT,
            java.util.Calendar.getInstance(),
            "Me",
            message
        )
    }

    fun handleEvent(authenticationEvent: ConversationEvent){
        when(authenticationEvent){
            is ConversationEvent.SendMessage -> {
                uiState.value=uiState.value.copy(
                    messages = uiState.value.messages.toMutableList().apply {
                        add(buildMessage(authenticationEvent.message))
                    }.toList()
                )
            }
            is ConversationEvent.UnsendMessage -> {
                uiState.value=uiState.value.copy(
                    messages = messagesExcluding(authenticationEvent.id)
                )
            }
            is ConversationEvent.SelectMessage -> {
                uiState.value=uiState.value.copy(
                    selectedMessage = uiState.value.messages.find { it.id==authenticationEvent.id }
                )
            }
            is ConversationEvent.UnsSelectMessage -> {
                uiState.value=uiState.value.copy(
                    selectedMessage = null
                )
            }
        }
    }
    private fun messagesExcluding(id:String): List<Message> {
        return uiState.value.messages.toMutableList().apply {
            removeAt(uiState.value.messages.indexOfFirst { it.id==uiState.value.selectedMessage?.id })
        }.toList()
    }
}