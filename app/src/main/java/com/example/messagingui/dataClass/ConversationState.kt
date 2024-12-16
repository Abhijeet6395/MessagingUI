package com.example.messagingui.dataClass

import com.example.messagingui.Contact
import com.example.messagingui.ContactFactory
import com.example.messagingui.MessageFactory

data class ConversationState(
    val messages: List<Message> = MessageFactory.makeMessage(),
    val contacts: List<Contact> = ContactFactory.getContacts(),
    val selectedMessage: Message? = null
)
