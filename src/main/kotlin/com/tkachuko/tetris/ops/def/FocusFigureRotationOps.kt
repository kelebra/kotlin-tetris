package com.tkachuko.tetris.ops.def

import com.tkachuko.tetris.model.FocusFigure

interface FocusFigureRotationOps {

    fun rotate(focusFigure: FocusFigure): FocusFigure
}