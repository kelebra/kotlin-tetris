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

    private fun isValidMove(previous: FocusFigure, vararg moved: Cell): Boolean {
        return moved
                .filterNot { previous.cells.contains(it) }
                .all { within(it) && data[it.y][it.x].isEmpty() }
    }

    private fun isRowFull(row: Array<Cell>): Boolean {
        return row.all { it.isFull() }
    }

    private fun shiftDown(rowIndex: Int) {
        for (y in rowIndex downTo 1) {
            data[y] = data[y - 1].map { it.copy(y = y) }.toTypedArray()
        }
    }

    fun draw(vararg cells: Cell) {
        cells.forEach { data[it.y][it.x] = it }
    }

    fun rotate(figure: FocusFigure): FocusFigure {
        val rotated = figure.cells.map { it.rotateAround(figure.center) }.toTypedArray()
        if (isValidMove(figure, *rotated)) {
            erase(*figure.cells)
            draw(*rotated)
            return figure.copy(cells = rotated)
        }
        return figure
    }

    fun move(figure: FocusFigure, movement: Movement): FocusFigure {
        val moved = figure.cells.map { it.move(movement) }.toTypedArray()
        if (isValidMove(figure, *moved)) {
            erase(*figure.cells)
            draw(*moved)
            return figure.copy(center = figure.center.move(movement), cells = moved)
        }
        return figure
    }

    fun isFull(): Boolean {
        return data.all { it.any { it.isFull() } }
    }

    fun middle(): Cell {
        return Cell(data[0].size / 2, 1)
    }

    fun clearFilledRows(): Int {
        if (isFull()) return 0

        val rowsToClear = data.filter { isRowFull(it) }.map { it[0].y }
        rowsToClear.sorted().forEach(this::shiftDown)

        return rowsToClear.distinct().size
    }

    override fun toString(): String {
        return data.joinToString(separator = "\n", transform = { it.map { it.color }.toString() })
    }
}