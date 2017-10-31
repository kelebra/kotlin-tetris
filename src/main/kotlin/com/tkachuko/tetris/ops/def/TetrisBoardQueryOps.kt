package com.tkachuko.tetris.ops.def

import com.tkachuko.tetris.model.TetrisBoard

interface TetrisBoardQueryOps {

    fun isFull(board: TetrisBoard): Boolean
}