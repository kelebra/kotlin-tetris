package com.tkachuko.tetris.keyboard

import com.tkachuko.tetris.Movement
import org.w3c.dom.events.KeyboardEvent
import kotlin.browser.document

class KeyboardListener(private val startGame: () -> Unit,
                       private val movementListener: (Movement) -> Unit,
                       private val rotationListener: () -> Unit) {

    var enableFigureRotation = false

    fun run() {
        document.onkeydown = { event ->
            val keyCode = (event as KeyboardEvent).keyCode
            if (enableFigureRotation) {
                when (keyCode) {
                    37 -> movementListener(Movement.Left)
                    39 -> movementListener(Movement.Right)
                    40 -> movementListener(Movement.Down)
                    38 -> rotationListener()
                }
            } else if (keyCode == 13) {
                enableFigureRotation = true
                startGame()
            }
        }
    }
}