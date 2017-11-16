package com.tkachuko.tetris

data class TetrisBoard(val data: Array<Array<Cell>>) {

    companion object {

        fun create(vertical: Int, horizontal: Int, vararg cells: Cell): TetrisBoard {
            val array = Array(vertical, { i -> Array(horizontal, { j -> Cell(i, j) }) })
            cells.forEach { array[it.y][it.x] = it }
            return TetrisBoard(array)
        }
    }

    private fun within(cell: Cell): Boolean {
        return cell.y < data.size && cell.y >= 0 && cell.x < data[0].size && cell.x >= 0
    }

    private fun erase(vararg cells: Cell) {
        cells.forEach { data[it.y][it.x] = it.erased() }
    }

    fun draw(vararg cells: Cell) {
        cells.forEach { data[it.y][it.x] = it }
    }

    fun move(figure: FocusFigure, movement: Movement): FocusFigure {
        val moved = figure.cells.map { it.move(movement) }.toTypedArray()
        val canMove = moved
                .filterNot { figure.cells.contains(it) }
                .all { within(it) && data[it.y][it.x].isEmpty() }
        if (canMove) {
            erase(*figure.cells)
            draw(*moved)
            return FocusFigure(figure.type, figure.center.move(movement), moved)
        }
        return figure
    }

    fun isFull(): Boolean {
        return data.all { it.any { it.isFull() } }
    }

    fun clearCompleteRows(): Int {
        val filledRows = data
                .filter { it.all { it.isFull() } }
                .toTypedArray()
                .flatten()
                .map { it.y }
                .distinct()
        filledRows.forEach { erase(*data[it]) }
        return filledRows.size
    }

    fun middle(): Cell {
        return Cell(data[0].size / 2, 1)
    }

    override fun toString(): String {
        return data.joinToString(separator = "\n", transform = { it.map { it.color }.toString() })
    }
}