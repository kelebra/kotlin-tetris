package com.tkachuko.tetris.ops.impl

import com.tkachuko.tetris.model.Cell
import com.tkachuko.tetris.model.FigureType
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@Suppress("unused")
class FigureCellsFactoryTest {

    private val factory = FigureCellsFactory

    @Test
    fun shouldCreateBox() {
        val figure = factory.create(FigureType.Box, Cell(0, 0))

        val coordinates = figure.cells.flatMap { listOf(it.y, it.x) }
        assertEquals(listOf(0, 0, 0, 1, 1, 0, 1, 1), coordinates)
    }

    @Test
    fun shouldCreateLine() {
        val figure = factory.create(FigureType.Line, Cell(3, 3))
        assertTrue { figure.cells.all { it.y == 3 } }
    }
}