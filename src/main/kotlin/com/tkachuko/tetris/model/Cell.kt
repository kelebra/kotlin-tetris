package com.tkachuko.tetris.model

data class Cell(val x: Int, val y: Int, val color: Color = Color.EMPTY) {

    fun isEmpty(): Boolean = color == Color.EMPTY

    fun isFull(): Boolean = !isEmpty()

    fun ofColor(color: Color): Cell = Cell(x, y, color)

    fun erased(): Cell = ofColor(Color.EMPTY)

    fun move(mv: Movement, distance: Int = 1): Cell =
            Cell(mv.dx(x, distance), mv.dy(y, distance), color)

    fun rotateAround(center: Cell): Cell {
        val horizontal = center.x - x
        val vertical = center.y - y
        return Cell(center.x + vertical, center.y - horizontal, color)
    }
}