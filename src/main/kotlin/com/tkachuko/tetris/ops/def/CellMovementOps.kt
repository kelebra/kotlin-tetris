package com.tkachuko.tetris.ops.def

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.Movement

interface CellMovementOps {

    fun move(cell: Cell, mv: Movement): Cell
}