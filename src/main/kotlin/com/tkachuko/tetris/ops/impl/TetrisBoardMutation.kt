package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.TetrisBoard
import com.tkachuko.tetris.ops.def.TetrisBoardMutationOps

object TetrisBoardMutation : TetrisBoardMutationOps {

    override fun draw(cell: Cell, board: TetrisBoard): Boolean {
        if (board[cell.y][cell.x].isFull()) return false
        else {
            board[cell.y][cell.x] = cell
            return true
        }
    }
}