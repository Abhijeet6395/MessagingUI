package com.example.messagingui.dataClass

import androidx.annotation.DrawableRes
import com.example.messagingui.constants.MessageDirection

data class Message(
    val id: String,
    val direction: MessageDirection,
    val dateTime: java.util.Calendar,
    val sender: String,
    val message: String?=null,
    @DrawableRes val image: Int?=null,
    val altText: String?=null
)
