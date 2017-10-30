package com.tkachuko.tetris.model

import kotlin.test.*
import kotlin.test.assertEquals

class CellTest {

    @Test fun cellShouldMoveUpwards(): Unit {
        val cell = Cell(0, 0)
        val moved = cell.move(Movement.Down)

        assertEquals(0, moved.x)
        assertEquals(1, moved.y)
        assertEquals(cell.color, moved.color)
    }
}