package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.Movement
import kotlin.test.Test
import kotlin.test.assertEquals

@Suppress("unused")
class CellMovementTest {

    @Test
    fun cellShouldMoveDown() {
        val cell = Cell(0, 0)
        val moved = CellMovement.move(cell, Movement.Down)

        assertEquals(cell.x, moved.x)
        assertEquals(1, moved.y)
        assertEquals(cell.color, moved.color)
    }

    @Test
    fun cellShouldMoveRight() {
        val cell = Cell(0, 0)
        val moved = CellMovement.move(cell, Movement.Right)

        assertEquals(1, moved.x)
        assertEquals(cell.y, moved.y)
        assertEquals(cell.color, moved.color)
    }

    @Test
    fun cellShouldMoveLeft() {
        val cell = Cell(1, 0)
        val moved = CellMovement.move(cell, Movement.Left)

        assertEquals(0, moved.x)
        assertEquals(cell.y, moved.y)
        assertEquals(cell.color, moved.color)
    }

    @Test
    fun returnsTheSameIfDistanceZero() {
        val cell = Cell(1, 1)
        val moved = CellMovement.move(cell, Movement.Right, 0)

        assertEquals(cell.y, moved.y)
        assertEquals(cell.x, moved.x)
    }
}