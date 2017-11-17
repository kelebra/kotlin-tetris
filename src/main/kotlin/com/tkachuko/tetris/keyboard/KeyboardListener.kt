package com.tkachuko.tetris.keyboard

import com.tkachuko.tetris.Movement
import org.w3c.dom.events.KeyboardEvent
import kotlin.browser.document

class KeyboardListener(private val movementListener: (Movement) -> Unit,
                       private val rotationListener: () -> Unit) {

    fun run() {
        document.onkeydown = { event ->
            when ((event as KeyboardEvent).keyCode) {
                37 -> movementListener(Movement.Left)
                38 -> rotationListener()
                39 -> movementListener(Movement.Right)
                40 -> movementListener(Movement.Down)
            }
        }
    }
}