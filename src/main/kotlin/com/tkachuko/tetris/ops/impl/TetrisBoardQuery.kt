package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.TetrisBoard
import com.tkachuko.tetris.ops.def.TetrisBoardQueryOps

object TetrisBoardQuery : TetrisBoardQueryOps {

    override fun isFull(board: TetrisBoard): Boolean = board.all { it.any { it.isFull() } }
}