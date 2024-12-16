package com.example.messagingui

import java.util.Calendar
import com.example.messagingui.constants.MessageDirection
import com.example.messagingui.dataClass.Message

object MessageFactory {
    fun makeMessage(): List<Message> {
        return listOf(
            Message(
                "0",
                MessageDirection.SENT,
                Calendar.getInstance().also {
                    it.add(Calendar.DAY_OF_YEAR, -5);
                    it.set(Calendar.HOUR_OF_DAY, 5)},
                "John",
                "Hello"
            ),
            Message(
                "1",
                MessageDirection.SENT,
                Calendar.getInstance(),
                "Jane",
                "Hi"
            ),
            Message(
                "2",
                MessageDirection.RECEIVED,
                Calendar.getInstance(),
                "John",
                "How are you?"
            ),
            Message(
                "3",
                MessageDirection.SENT,
                Calendar.getInstance(),
                "Jane",
                "I'm good"
            ),
            Message(
                "4",
                MessageDirection.RECEIVED,
                Calendar.getInstance(),
                "John",
                "That's great"
            ),
            Message(
                "5",
                MessageDirection.SENT,
                Calendar.getInstance(),
                "Jane",
                "Yes"
            )
        )
    }
}