package com.tkachuko.tetris.model

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Suppress("unused")
class CellTest {

    @Test
    fun isEmptyByDefault() {
        val default = Cell(100, 100)
        assertTrue { default.isEmpty() }
        assertFalse { default.isFull() }
    }

    @Test
    fun isNotEmptyWithCustomColor() {
        val default = Cell(100, 100, color = Color.BLUE)
        assertFalse { default.isEmpty() }
        assertTrue { default.isFull() }
    }
}