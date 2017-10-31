package com.tkachuko.tetris.ops.def

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.TetrisBoard

interface TetrisBoardMutationOps {

    fun draw(cell: Cell, board: TetrisBoard): Boolean
}