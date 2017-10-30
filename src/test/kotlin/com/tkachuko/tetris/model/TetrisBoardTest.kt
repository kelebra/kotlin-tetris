package com.tkachuko.tetris.model

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Suppress("unused")
class TetrisBoardTest {

    @Test
    fun boardIsNotFullByDefault() {
        val board = TetrisBoard(10, 10)
        assertFalse { board.isFull() }
    }

    @Test
    fun boardIsFullWhenAllRowsHaveNonEmptyCell() {
        val board = TetrisBoard(5, 5)
        board.draw(Cell(0, 0, Color.BLUE))
        board.draw(Cell(1, 1, Color.BLUE))
        board.draw(Cell(2, 2, Color.BLUE))
        board.draw(Cell(3, 3, Color.BLUE))
        board.draw(Cell(4, 4, Color.BLUE))

        assertTrue { board.isFull() }
    }
}