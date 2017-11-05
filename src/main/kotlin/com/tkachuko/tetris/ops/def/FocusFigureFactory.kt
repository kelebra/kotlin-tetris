package com.tkachuko.tetris.ops.def

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.FigureType
import com.tkachuko.tetris.model.FocusFigure

interface FocusFigureFactory {

    fun create(figureType: FigureType, leftMost: Cell): FocusFigure
}