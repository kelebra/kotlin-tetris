package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.Color
import com.tkachuko.tetris.ops.def.CellPaintingOps

object CellPainting : CellPaintingOps {

    override fun paint(cell: Cell, color: Color): Cell = Cell(cell.x, cell.y, cell.size, color)

    override fun erase(cell: Cell): Cell = Cell(cell.x, cell.y)
}