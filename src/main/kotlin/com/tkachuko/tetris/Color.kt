package com.tkachuko.tetris

enum class Color(val hex: String) {

    RED("#ffb3ba"),
    ORANGE("#ffdfba"),
    YELLOW("#f1f105"),
    GREEN("#baffc9"),
    BLUE("#bae1ff"),
    PURPLE("#c9c9ff"),
    EMPTY("-------");

    override fun toString(): String{
        return hex
    }


}