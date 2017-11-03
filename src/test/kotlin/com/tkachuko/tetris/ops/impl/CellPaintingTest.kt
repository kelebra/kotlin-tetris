package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.Color
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("unused")
class CellPaintingTest {

    @Test
    fun shouldEraseCell() {
        val cell = Cell(1,1)
        val erased = CellPainting.erase(cell)

        assertEquals(cell.x, erased.x)
        assertEquals(cell.y, erased.y)
        assertEquals(cell.color, Color.EMPTY)
    }

    @Test
    fun shouldPaintCell() {
        val newColor = Color.YELLOW

        val cell = Cell(1, 1, color = Color.BLUE)
        val painted = CellPainting.paint(cell, newColor)

        assertEquals(newColor, painted.color)
    }
}