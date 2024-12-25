package com.example.messagingui.constants

sealed class ConversationEvent {
    data class SendMessage(val message: String) : ConversationEvent()
    data class UnsendMessage(val id: String) : ConversationEvent()
    data class SelectMessage(val id: String) : ConversationEvent()
    object UnsSelectMessage : ConversationEvent()
}