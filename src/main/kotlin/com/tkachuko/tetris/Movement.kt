package com.tkachuko.tetris

typealias Coordinate = Int
typealias Distance = Int

typealias Move = (Coordinate, Distance) -> Int

enum class Movement(val dx: Move = { x, _ -> x },
                    val dy: Move = { y, _ -> y }) {

    Up(dy = { y, distance -> y - distance }),

    Down(dy = { y, distance -> y + distance }),

    Right(dx = { x, distance -> x + distance }),

    Left(dx = { x, distance -> x - distance })
}