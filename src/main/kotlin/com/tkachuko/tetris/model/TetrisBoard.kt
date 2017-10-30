package com.tkachuko.tetris.model

class TetrisBoard(vertical: Int, horizontal: Int) {

    private val net = Array(
            vertical,
            { i ->
                Array(horizontal,
                        { j -> Cell(j, i) }
                )
            }
    )

    fun isFull(): Boolean = net.all { it.any { it.isFull() } }

    fun draw(cell: Cell) {
        net[cell.y][cell.x] = cell
    }
}