package com.tkachuko.tetris

data class Cell(val x: Int, val y: Int, val color: Color = Color.EMPTY) {

    fun isEmpty(): Boolean = color == Color.EMPTY

    fun isFull(): Boolean = !isEmpty()

    fun ofColor(color: Color): Cell = copy(color = color)

    fun erased(): Cell = ofColor(Color.EMPTY)

    fun move(mv: Movement, distance: Int = 1): Cell =
            copy(x = mv.dx(x, distance), y = mv.dy(y, distance))

    fun rotateAround(center: Cell): Cell {
        val horizontal = center.x - x
        val vertical = center.y - y
        return copy(x = center.x + vertical, y = center.y - horizontal)
    }
}