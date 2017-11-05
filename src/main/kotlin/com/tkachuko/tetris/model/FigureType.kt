package com.tkachuko.tetris.model

import com.tkachuko.tetris.model.Color.*

enum class FigureType(val color: Color) {

    Line(color = BLUE),

    Box(color = YELLOW),

    Megenta(color = PURPLE),

    RightTurn(color = GREEN),

    LeftTurn(color = RED),

    Inverse(color = BLUE),

    Outverse(color = ORANGE)
}