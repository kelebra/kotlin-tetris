package com.tkachuko.tetris

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

@Suppress("unused")
class FocusFigureTest {

    @Test
    fun shouldGenerateFourRotationsOfMegenta() {
        val figure = FocusFigure.create(FigureType.Megenta, Cell(5, 5))

        val firstRotation = figure.rotate()
        val secondRotation = firstRotation.rotate()
        val thirdRotation = secondRotation.rotate()
        val fourthRotation = thirdRotation.rotate()

        assertNotEquals(firstRotation, figure)
        assertNotEquals(secondRotation, firstRotation)
        assertNotEquals(thirdRotation, secondRotation)
        assertNotEquals(fourthRotation, thirdRotation)

        assertEquals(figure, fourthRotation)
    }

    @Test
    fun shouldGenerateTwoRotationsOfLine() {
        val figure = FocusFigure.create(FigureType.Line, Cell(4, 4))

        val firstRotation = figure.rotate()
        val secondRotation = firstRotation.rotate()

        assertEquals(4, firstRotation.cells.distinctBy { it.x }.single().x)
        assertEquals(4, secondRotation.cells.distinctBy { it.y }.single().y)
    }

    @Test
    fun shouldCreateBox() {
        val figure = FocusFigure.create(FigureType.Box, Cell(0, 0))

        val coordinates = figure.cells.flatMap { listOf(it.y, it.x) }
        assertEquals(listOf(0, 0, 0, 1, 1, 0, 1, 1), coordinates)
    }

    @Test
    fun shouldCreateLine() {
        val figure = FocusFigure.create(FigureType.Line, Cell(3, 3))
        assertTrue { figure.cells.all { it.y == 3 } }
    }
}