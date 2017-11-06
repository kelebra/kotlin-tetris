package com.tkachuko.tetris.ops.def

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.FocusFigure
import com.tkachuko.tetris.model.Movement
import com.tkachuko.tetris.model.TetrisBoard

interface TetrisBoardOps {

    fun erase(board: TetrisBoard, vararg cells: Cell)

    fun draw(board: TetrisBoard, vararg cells: Cell)

    fun move(figure: FocusFigure, movement: Movement, board: TetrisBoard): FocusFigure

    fun isFull(board: TetrisBoard): Boolean
}