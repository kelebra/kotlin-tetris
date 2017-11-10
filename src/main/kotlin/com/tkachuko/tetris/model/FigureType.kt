package com.tkachuko.tetris.model

import com.tkachuko.tetris.model.Color.*

enum class FigureType(val color: Color) {

    Line(color = BLUE) {

        override fun structureAround(center: Cell): Array<Cell> {
            val leftMost = center.move(Movement.Left, 2)
            val left = center.move(Movement.Left)
            val right = center.move(Movement.Right)
            return arrayOf(leftMost, left, center, right)
        }
    },

    Box(color = YELLOW) {
        override fun structureAround(center: Cell): Array<Cell> {
            val rightUp = center.move(Movement.Right)
            return arrayOf(center, rightUp, center.move(Movement.Down), rightUp.move(Movement.Down))
        }
    },

    Megenta(color = PURPLE) {
        override fun structureAround(center: Cell): Array<Cell> {
            val up = center.move(Movement.Up)
            val left = center.move(Movement.Left)
            val right = center.move(Movement.Right)
            return arrayOf(left, center, up, right)
        }
    },

    RightTurn(color = GREEN) {
        override fun structureAround(center: Cell): Array<Cell> {
            val up = center.move(Movement.Up)
            val left = center.move(Movement.Left)
            val right = up.move(Movement.Right)
            return arrayOf(left, center, up, right)
        }
    },

    LeftTurn(color = RED) {
        override fun structureAround(center: Cell): Array<Cell> {
            val up = center.move(Movement.Up)
            val left = up.move(Movement.Left)
            val right = center.move(Movement.Right)
            return arrayOf(left, up, center, right)
        }
    },

    Inverse(color = BLUE) {
        override fun structureAround(center: Cell): Array<Cell> {
            val left = center.move(Movement.Left)
            val right = center.move(Movement.Right)
            val up = left.move(Movement.Up)
            return arrayOf(up, left, center, right)
        }
    },

    Outverse(color = ORANGE) {
        override fun structureAround(center: Cell): Array<Cell> {
            val left = center.move(Movement.Left)
            val right = center.move(Movement.Right)
            val up = right.move(Movement.Up)
            return arrayOf(left, center, right, up)
        }
    };

    abstract fun structureAround(center: Cell): Array<Cell>
}