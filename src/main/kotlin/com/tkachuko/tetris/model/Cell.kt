package com.tkachuko.tetris.model

class Cell(val x: Int, val y: Int, val size: Int = 1, val color: Color = Color.EMPTY) {

    fun isEmpty(): Boolean = color == Color.EMPTY

    fun isFull(): Boolean = !isEmpty()
}