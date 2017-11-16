package com.tkachuko.tetris

import com.tkachuko.tetris.Movement.Down

class Game(private val drawing: DrawingBoard,
           private val board: TetrisBoard) {

    private var focusFigure = createNextFigure()

    fun gravityTick() {
        val nextFigure = board.move(focusFigure, Down)
        val focusFigureCanNotMove = focusFigure == nextFigure

        focusFigure = if (focusFigureCanNotMove) createNextFigure() else nextFigure

        drawing.render(board)
    }

    private fun createNextFigure(): FocusFigure {
        return FocusFigure.random(board.middle())
    }

    fun start() {
        board.draw(*focusFigure.cells)
        drawing.render(board)
    }
}