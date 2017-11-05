package com.tkachuko.tetris.model

typealias Radius = Int
typealias Coordinate = Int
typealias Distance = Int

typealias Move = (Coordinate, Radius, Distance) -> Int

enum class Movement(val dx: Move = { x, _, _ -> x },
                    val dy: Move = { y, _, _ -> y }) {

    Up(dy = { y, radius, distance -> y - distance * radius }),

    Down(dy = { y, radius, distance -> y + distance * radius }),

    Right(dx = { x, radius, distance -> x + distance * radius }),

    Left(dx = { x, radius, distance -> x - distance * radius })
}