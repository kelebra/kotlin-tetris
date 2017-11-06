package com.tkachuko.tetris.model

class FocusFigure(val type: FigureType, val center: Cell, val cells: Array<Cell>) {

    init {
        if (cells.any { it.color != type.color })
            throw IllegalArgumentException("Cells should all have the same color")
        if (!cells.contains(center))
            throw IllegalArgumentException("Cells should contain its center")
    }
}