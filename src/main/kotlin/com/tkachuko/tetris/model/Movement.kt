package com.tkachuko.tetris.model

typealias Move = (Int) -> Int

enum class Movement(val dx: Move = { x -> x }, val dy: Move = { y -> y }) {

    Down(dy = { it + 1 }),

    Right(dx = { it + 1 }),

    Left(dx = { it - 1 })
}

