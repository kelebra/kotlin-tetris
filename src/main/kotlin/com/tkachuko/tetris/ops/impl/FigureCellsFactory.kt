package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.Movement.*
import com.tkachuko.tetris.ops.def.Center
import com.tkachuko.tetris.ops.def.FocusFigureFactory

object FigureCellsFactory : FocusFigureFactory {

    override fun createLine(center: Center): Array<Cell> {
        val leftMost = center.move(Left, 2)
        val left = center.move(Left)
        val right = center.move(Right)
        return arrayOf(leftMost, left, center, right)
    }

    override fun createBox(center: Center): Array<Cell> {
        val rightUp = center.move(Right)
        return arrayOf(center, rightUp, center.move(Down), rightUp.move(Down))
    }

    override fun createMegenta(center: Center): Array<Cell> {
        val up = center.move(Up)
        val left = center.move(Left)
        val right = center.move(Right)
        return arrayOf(left, center, up, right)
    }

    override fun createRightTurn(center: Center): Array<Cell> {
        val up = center.move(Up)
        val left = center.move(Left)
        val right = up.move(Right)
        return arrayOf(left, center, up, right)
    }

    override fun createLeftTurn(center: Center): Array<Cell> {
        val up = center.move(Up)
        val left = up.move(Left)
        val right = center.move(Right)
        return arrayOf(left, up, center, right)
    }

    override fun createInverse(center: Center): Array<Cell> {
        val left = center.move(Left)
        val right = center.move(Right)
        val up = left.move(Up)
        return arrayOf(up, left, center, right)
    }

    override fun createOutverse(center: Center): Array<Cell> {
        val left = center.move(Left)
        val right = center.move(Right)
        val up = right.move(Up)
        return arrayOf(left, center, right, up)
    }
}