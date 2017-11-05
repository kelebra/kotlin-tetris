package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.*
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

@Suppress("unused")
class TetrisBoardOperationsTest {

    private val ops = TetrisBoardOperations(CellMovement, CellPainting)
    private val factory = FigureCellsFactory(CellMovement, CellPainting)

    @Test
    fun boardIsFullWhenAllRowsHaveNonEmptyCell() {
        val board = create(5, 5,
                Cell(0, 0, color = Color.BLUE),
                Cell(1, 1, color = Color.BLUE),
                Cell(1, 1, color = Color.BLUE),
                Cell(2, 2, color = Color.BLUE),
                Cell(3, 3, color = Color.BLUE),
                Cell(4, 4, color = Color.BLUE)
        )

        assertTrue { ops.isFull(board) }
    }

    @Test
    fun boardIsNotFullByDefault() {
        val board = create(10, 10)
        assertFalse { ops.isFull(board) }
    }

    @Test
    fun shouldMoveLineDown() {
        val line = factory.create(FigureType.Line, Cell(0, 0))
        val board = create(4, 4, *line)

        val movedLine = ops.move(line, Movement.Down, board)

        assertNotEquals(line, movedLine)
        assertTrue { board[0].all { it.isEmpty() } }
        assertTrue { board[1].all { it.color == FigureType.Line.color } }
    }
}