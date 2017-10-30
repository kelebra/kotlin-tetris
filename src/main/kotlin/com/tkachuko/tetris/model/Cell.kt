package com.tkachuko.tetris.model

class Cell(val x: Int, val y: Int, val color: Color = Color.EMPTY) {

    fun of(color: Color): Cell = Cell(x, y, color)

    fun move(mv: Movement): Cell = Cell(mv.dx(x), mv.dy(y), color)
}