package com.tkachuko.tetris

import com.tkachuko.tetris.Cell
import com.tkachuko.tetris.Color
import com.tkachuko.tetris.Movement
import kotlin.test.Test
import kotlin.test.assertEquals
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

    @Test
    fun cellShouldChangeColor() {
        val newColor = Color.YELLOW

        val cell = Cell(1, 1, color = Color.BLUE)
        val painted = cell.ofColor(newColor)

        assertEquals(newColor, painted.color)
    }

    @Test
    fun shouldEraseCell() {
        val cell = Cell(1, 1)
        val erased = cell.erased()

        assertEquals(cell.x, erased.x)
        assertEquals(cell.y, erased.y)
        assertEquals(cell.color, Color.EMPTY)
    }

    @Test
    fun cellShouldMoveDown() {
        val cell = Cell(0, 0)
        val moved = cell.move(Movement.Down)

        assertEquals(cell.x, moved.x)
        assertEquals(1, moved.y)
        assertEquals(cell.color, moved.color)
    }

    @Test
    fun cellShouldMoveRight() {
        val cell = Cell(0, 0)
        val moved = cell.move(Movement.Right)

        assertEquals(1, moved.x)
        assertEquals(cell.y, moved.y)
        assertEquals(cell.color, moved.color)
    }

    @Test
    fun cellShouldMoveLeft() {
        val cell = Cell(1, 0)
        val moved = cell.move(Movement.Left)

        assertEquals(0, moved.x)
        assertEquals(cell.y, moved.y)
        assertEquals(cell.color, moved.color)
    }

    @Test
    fun returnsTheSameIfDistanceZero() {
        val cell = Cell(1, 1)
        val moved = cell.move(Movement.Right, 0)

        assertEquals(cell.y, moved.y)
        assertEquals(cell.x, moved.x)
    }

    @Test
    fun cellCanBeRotatedIfLeftOfCenter() {
        val center = Cell(5, 5)
        val cell = Cell(4, 5)

        val result = cell.rotateAround(center)

        assertEquals(5, result.x)
        assertEquals(4, result.y)
    }
}