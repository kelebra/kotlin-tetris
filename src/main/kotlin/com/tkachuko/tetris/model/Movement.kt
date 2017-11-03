package com.tkachuko.tetris.model

typealias Radius = Int
typealias Coordinate = Int

typealias Move = (Coordinate, Radius) -> Int

enum class Movement(val dx: Move = { x, _ -> x }, val dy: Move = { y, _ -> y }) {

    Down(dy = { y, radius -> y + radius + 1 }),

    Right(dx = { x, radius -> x + radius + 1 }),

    Left(dx = { x, radius -> x - radius - 1 })
}