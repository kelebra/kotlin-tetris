package com.tkachuko.tetris

class Game(private val drawing: DrawingBoard,
           private val board: TetrisBoard) {

    private var focusFigure = createNextFigure()
    private var score = 0

    fun movementTick(movement: Movement, shouldChangeFigure: Boolean) {

        val nextFigure = board.move(focusFigure, movement)
        val focusFigureTheSame = focusFigure == nextFigure

        focusFigure = if (focusFigureTheSame && shouldChangeFigure) createNextFigure() else nextFigure
        if (focusFigureTheSame) updateScore(board.clearFilledRows())

        drawing.render(board, score)
    }

    private fun updateScore(clearedRows: Int) {
        score += when (clearedRows) {
            1    -> 40
            2    -> 100
            3    -> 300
            4    -> 1200
            else -> 0
        }
    }

    fun rotateFocusFigure() {
        val nextFigure = board.rotate(focusFigure)
        focusFigure = nextFigure
        drawing.render(board, score)
    }

    private fun createNextFigure(): FocusFigure {
        return FocusFigure.random(board.middle())
    }

    fun start() {
        board.draw(*focusFigure.cells)
        drawing.render(board, score)
    }
}