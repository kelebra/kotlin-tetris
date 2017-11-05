package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.FigureType
import com.tkachuko.tetris.model.FigureType.*
import com.tkachuko.tetris.model.FocusFigure
import com.tkachuko.tetris.model.Movement.*
import com.tkachuko.tetris.ops.def.CellMovementOps
import com.tkachuko.tetris.ops.def.CellPaintingOps
import com.tkachuko.tetris.ops.def.FocusFigureFactory

class FigureCellsFactory(private val mv: CellMovementOps,
                         private val cl: CellPaintingOps) : FocusFigureFactory {

    private val size = 4

    override fun create(figureType: FigureType, leftMost: Cell): FocusFigure {
        val cells =
                when (figureType) {
                    Line ->
                        Array(size, { offset -> mv.move(leftMost, Right, offset) })
                    Box -> {
                        val rightUp = mv.move(leftMost, Right)
                        arrayOf(leftMost, rightUp, mv.move(leftMost, Down), mv.move(rightUp, Down))
                    }
                    Megenta -> {
                        val rightBot = mv.move(leftMost, Right)
                        arrayOf(leftMost, rightBot, mv.move(rightBot, Up), mv.move(rightBot, Up, 2))
                    }
                    RightTurn -> {
                        val rightBot = mv.move(leftMost, Right)
                        val middle = mv.move(rightBot, Up)
                        arrayOf(leftMost, rightBot, middle, mv.move(middle, Right))
                    }
                    LeftTurn -> {
                        val rightTop = mv.move(leftMost, Right)
                        val middleBot = mv.move(rightTop, Down)
                        arrayOf(leftMost, rightTop, middleBot, mv.move(middleBot, Right))
                    }
                    Inverse -> {
                        val down = mv.move(leftMost, Down)
                        arrayOf(leftMost, down, mv.move(down, Right), mv.move(down, Right, 2))
                    }
                    Outverse -> {
                        val last = mv.move(leftMost, Right, 2)
                        arrayOf(leftMost, mv.move(leftMost, Right), last, mv.move(last, Up, 1))
                    }
                }
        return cells.map { cl.paint(it, figureType.color) }.toTypedArray()
    }

}