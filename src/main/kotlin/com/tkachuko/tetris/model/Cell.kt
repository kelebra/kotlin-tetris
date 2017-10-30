package com.tkachuko.tetris.model

class Cell(val x: Int, val y: Int, val color: Color = Color.EMPTY) {

    fun isEmpty(): Boolean = color == Color.EMPTY

    fun isFull(): Boolean = !isEmpty()
}