package com.tkachuko.tetris.model

typealias TetrisBoard = Array<Array<Cell>>

fun create(vertical: Int, horizontal: Int, vararg cells: Cell): TetrisBoard {
    val array = Array(vertical, { i -> Array(horizontal, { j -> Cell(i, j) }) })
    cells.forEach { array[it.y][it.x] = it }
    return array
}