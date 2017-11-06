package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.FigureType
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@Suppress("unused")
class FigureCellsFactoryTest {

    @Test
    fun shouldCreateBox() {
        val type = FigureType.Box

        val factory = FigureCellsFactory
        val figure = factory.create(type, Cell(0, 0))

        assertTrue { figure.cells.all { it.color == type.color } }
        val coordinates = figure.cells.flatMap { listOf(it.y, it.x) }
        assertEquals(listOf(0, 0, 0, 1, 1, 0, 1, 1), coordinates)
    }
}