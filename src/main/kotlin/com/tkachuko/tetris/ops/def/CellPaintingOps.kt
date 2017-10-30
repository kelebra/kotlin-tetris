package com.tkachuko.tetris.ops.def

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.Color

interface CellPaintingOps {

    fun paint(cell: Cell, color: Color): Cell

    fun erase(cell: Cell): Cell
}