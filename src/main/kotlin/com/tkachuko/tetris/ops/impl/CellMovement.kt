package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.Movement
import com.tkachuko.tetris.ops.def.CellMovementOps

object CellMovement : CellMovementOps {

    override fun move(cell: Cell, mv: Movement): Cell =
            Cell(mv.dx(cell.x, cell.size), mv.dy(cell.y, cell.size), cell.size, cell.color)
}