package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.FocusFigure
import com.tkachuko.tetris.model.Movement
import com.tkachuko.tetris.model.TetrisBoard
import com.tkachuko.tetris.ops.def.TetrisBoardOps

object TetrisBoardOperations : TetrisBoardOps {

    override fun erase(board: TetrisBoard, vararg cells: Cell) {
        cells.forEach { board[it.y][it.x] = it.erased() }
    }

    override fun draw(board: TetrisBoard, vararg cells: Cell) {
        cells.forEach { board[it.y][it.x] = it }
    }

    override fun move(figure: FocusFigure,
                      movement: Movement,
                      board: TetrisBoard): FocusFigure {
        val moved = figure.cells.map { it.move(movement) }.toTypedArray()
        val canMove = moved.all { board[it.y][it.x].isEmpty() }
        if (canMove) {
            erase(board, *figure.cells)
            draw(board, *moved)
            return FocusFigure(figure.type, figure.center.move(movement), moved)
        }
        return figure
    }

    override fun isFull(board: TetrisBoard): Boolean {
        return board.all { it.any { it.isFull() } }
    }
}