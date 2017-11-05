package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.FigureType
import com.tkachuko.tetris.model.FocusFigure
import com.tkachuko.tetris.model.create
import com.tkachuko.tetris.ops.def.FocusFigureFactory
import com.tkachuko.tetris.ops.def.TetrisBoardOps

class Game(val vertical: Int,
           val horizontal: Int,
           private val factory: FocusFigureFactory,
           private val boardOps: TetrisBoardOps) {

    private val board = create(vertical, horizontal)

    tailrec fun play(current: FocusFigure, next: FigureType): Boolean {
        if (boardOps.isFull(board)) return false
        else return false
    }
}