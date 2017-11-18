package com.tkachuko.tetris

class Game(private val drawing: DrawingBoard,
           private val board: TetrisBoard) {

    private var focusFigure = createNextFigure()

    fun movementTick(movement: Movement, shouldChangeFigure: Boolean) {
        board.clearFilledRows()

        val nextFigure = board.move(focusFigure, movement)
        val focusFigureTheSame = focusFigure == nextFigure

        focusFigure = if (focusFigureTheSame && shouldChangeFigure) createNextFigure() else nextFigure

        drawing.render(board)
    }

    fun rotateFocusFigure() {
        val nextFigure = board.rotate(focusFigure)
        focusFigure = nextFigure
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