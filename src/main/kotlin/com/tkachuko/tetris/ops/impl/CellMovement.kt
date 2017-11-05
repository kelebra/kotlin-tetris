package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.Distance
import com.tkachuko.tetris.model.Movement
import com.tkachuko.tetris.ops.def.CellMovementOps

object CellMovement : CellMovementOps {

    override fun move(cell: Cell, mv: Movement, distance: Distance): Cell = Cell(
            mv.dx(cell.x, cell.size, distance),
            mv.dy(cell.y, cell.size, distance),
            cell.size, cell.color
    )
}