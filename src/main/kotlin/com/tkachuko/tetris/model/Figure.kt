package com.tkachuko.tetris.model

import com.tkachuko.tetris.model.Color.*

sealed class Figure(val color: Color)

object Line : Figure(color = BLUE)

object Box : Figure(color = YELLOW)

object Megenta : Figure(color = PURPLE)

object RightTurn : Figure(color = GREEN)

object LeftTurn : Figure(color = RED)

object Inverse : Figure(color = BLUE)

object Outverse : Figure(color = ORANGE)