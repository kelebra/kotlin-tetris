package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.Color
import com.tkachuko.tetris.model.create
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@Suppress("unused")
class TetrisBoardQueryTest {

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

        assertTrue { TetrisBoardQuery.isFull(board) }
    }

    @Test
    fun boardIsNotFullByDefault() {
        val board = create(10, 10)
        assertFalse { TetrisBoardQuery.isFull(board) }
    }
}