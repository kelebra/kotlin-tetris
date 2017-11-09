package com.tkachuko.tetris.model

import com.tkachuko.tetris.ops.impl.FigureCellsFactory
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

@Suppress("unused")
class FocusFigureTest {

    private val factory = FigureCellsFactory

    @Test
    fun shouldGenerateFourRotationsOfMegenta() {
        val figure = factory.create(FigureType.Megenta, Cell(5, 5))

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
        val figure = factory.create(FigureType.Line, Cell(4, 4))

        val firstRotation = figure.rotate()
        val secondRotation = firstRotation.rotate()

        assertEquals(4, firstRotation.cells.distinctBy { it.x }.single().x)
        assertEquals(4, secondRotation.cells.distinctBy { it.y }.single().y)
    }
}