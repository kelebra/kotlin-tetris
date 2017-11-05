package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.FocusFigure
import com.tkachuko.tetris.model.Movement
import com.tkachuko.tetris.model.TetrisBoard
import com.tkachuko.tetris.ops.def.CellMovementOps
import com.tkachuko.tetris.ops.def.CellPaintingOps
import com.tkachuko.tetris.ops.def.TetrisBoardOps

class TetrisBoardOperations(private val cellMove: CellMovementOps,
                            private val cellPainting: CellPaintingOps) : TetrisBoardOps {

    override fun erase(board: TetrisBoard, vararg cells: Cell) {
        cells.forEach { board[it.y][it.x] = cellPainting.erase(it) }
    }

    override fun draw(board: TetrisBoard, vararg cells: Cell) {
        cells.forEach { board[it.y][it.x] = it }
    }

    override fun move(focusFigure: FocusFigure,
                      movement: Movement,
                      board: TetrisBoard): FocusFigure {
        val moved = focusFigure.map { cellMove.move(it, movement) }.toTypedArray()
        val canMove = moved.all { board[it.y][it.x].isEmpty() }
        if (canMove) {
            erase(board, *focusFigure)
            draw(board, *moved)
            return moved
        }
        return arrayOf()
    }

    override fun isFull(board: TetrisBoard): Boolean {
        return board.all { it.any { it.isFull() } }
    }
}