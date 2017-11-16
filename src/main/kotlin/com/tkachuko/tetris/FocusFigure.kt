package com.tkachuko.tetris

import kotlin.js.Math

data class FocusFigure(val type: FigureType, val center: Cell, val cells: Array<Cell>) {

    init {
        if (cells.isEmpty())
            throw IllegalArgumentException("Figure is not empty")
        if (cells.any { it.color != type.color })
            throw IllegalArgumentException("Cells should all have the same color")
        if (!cells.contains(center))
            throw IllegalArgumentException("Cell should belong to cells")
    }

    fun rotate(): FocusFigure {
        return FocusFigure(type, center, cells.map { it.rotateAround(center) }.toTypedArray())
    }

    companion object {

        fun random(center: Cell): FocusFigure {
            val types = FigureType.values()
            val rnd = Math.random() * types.size
            return create(types[rnd.toInt()], center)
        }

        fun create(figureType: FigureType, center: Cell): FocusFigure {
            val color = figureType.color
            val cells = figureType.structureAround(center).map { it.ofColor(color) }
            return FocusFigure(figureType, center.ofColor(color), cells.toTypedArray())
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class.js != other::class.js) return false

        other as FocusFigure

        if (type != other.type) return false
        if (center != other.center) return false
        if (!cells.contentEquals(other.cells)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + center.hashCode()
        result = 31 * result + cells.contentDeepHashCode()
        return result
    }

    override fun toString(): String {
        return "FocusFigure(type=$type, center=$center, cells=${cells.contentDeepToString()})"
    }
}