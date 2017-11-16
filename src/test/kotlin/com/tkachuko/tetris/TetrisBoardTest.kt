package com.tkachuko.tetris

import kotlin.test.*

@Suppress("unused")
class TetrisBoardTest {

    @Test
    fun boardIsFullWhenAllRowsHaveNonEmptyCell() {
        val board = TetrisBoard.create(5, 5,
                Cell(0, 0, color = Color.BLUE),
                Cell(1, 1, color = Color.BLUE),
                Cell(1, 1, color = Color.BLUE),
                Cell(2, 2, color = Color.BLUE),
                Cell(3, 3, color = Color.BLUE),
                Cell(4, 4, color = Color.BLUE)
        )

        assertTrue { board.isFull() }
    }

    @Test
    fun boardIsNotFullByDefault() {
        val board = TetrisBoard.create(10, 10)
        assertFalse { board.isFull() }
    }

    @Test
    fun shouldMoveLineDown() {
        val line = FocusFigure.create(FigureType.Line, Cell(2, 0))
        val board = TetrisBoard.create(4, 4, *line.cells)
        val movedLine = board.move(line, Movement.Down)

        assertNotEquals(line, movedLine)
        assertTrue { board.data[0].all { it.isEmpty() } }
        assertTrue { board.data[1].all { it.isFull() } }
    }

    @Test
    fun shouldMoveLineDownThreeTimes() {
        val line = FocusFigure.create(FigureType.Line, Cell(2, 1))
        val board = TetrisBoard.create(5, 4, *line.cells)

        val firstMove = board.move(line, Movement.Down)
        val secondMove = board.move(firstMove, Movement.Down)
        val thirdMove = board.move(secondMove, Movement.Down)

        assertNotEquals(line, firstMove)
        assertNotEquals(firstMove, secondMove)
        assertNotEquals(secondMove, thirdMove)

        assertTrue { board.data[0].all { it.isEmpty() } }
        assertTrue { board.data[1].all { it.isEmpty() } }
        assertTrue { board.data[2].all { it.isEmpty() } }
        assertTrue { board.data[3].all { it.isEmpty() } }
        assertTrue { board.data[4].all { it.isFull() } }
    }

    @Test
    fun shouldDefineMiddleInSecondRow() {
        val board = TetrisBoard.create(10, 10)
        val middle = board.middle()

        assertEquals(1, middle.y)
        assertEquals(5, middle.x)
    }
}