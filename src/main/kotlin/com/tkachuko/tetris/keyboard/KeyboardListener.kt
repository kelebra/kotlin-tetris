package com.tkachuko.tetris.keyboard

import com.tkachuko.tetris.Movement
import org.w3c.dom.events.KeyboardEvent
import kotlin.browser.document

class KeyboardListener(private val listener: (Movement) -> Unit) {

    fun run() {
        document.onkeydown = { event ->
            when ((event as KeyboardEvent).keyCode) {
                37 -> listener(Movement.Left)
                39 -> listener(Movement.Right)
                40 -> listener(Movement.Down)
            }
        }
    }
}