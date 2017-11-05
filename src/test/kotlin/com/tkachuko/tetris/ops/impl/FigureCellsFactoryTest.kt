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

        val factory = FigureCellsFactory(CellMovement, CellPainting)
        val cells = factory.create(type, Cell(0, 0))

        assertTrue { cells.all { it.color == type.color } }
        val coordinates = cells.flatMap { listOf(it.y, it.x) }
        assertEquals(listOf(0, 0, 0, 1, 1, 0, 1, 1), coordinates)
    }
}