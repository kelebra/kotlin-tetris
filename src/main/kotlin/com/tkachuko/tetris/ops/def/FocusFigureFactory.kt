package com.tkachuko.tetris.ops.def

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.FigureType
import com.tkachuko.tetris.model.FigureType.*
import com.tkachuko.tetris.model.FocusFigure

typealias Center = Cell

interface FocusFigureFactory {

    fun create(figureType: FigureType, center: Center): FocusFigure {
        val color = figureType.color
        val cells = when (figureType) {
            Line      -> createLine(center)
            Box       -> createBox(center)
            Megenta   -> createMegenta(center)
            RightTurn -> createRightTurn(center)
            LeftTurn  -> createLeftTurn(center)
            Inverse   -> createInverse(center)
            Outverse  -> createOutverse(center)
        }
        return FocusFigure(
                type = figureType,
                center = center.ofColor(color),
                cells = cells.map { it.ofColor(color) }.toTypedArray()
        )
    }

    fun createLine(center: Center): Array<Cell>

    fun createBox(center: Center): Array<Cell>

    fun createMegenta(center: Center): Array<Cell>

    fun createRightTurn(center: Center): Array<Cell>

    fun createLeftTurn(center: Center): Array<Cell>

    fun createInverse(center: Center): Array<Cell>

    fun createOutverse(center: Center): Array<Cell>
}