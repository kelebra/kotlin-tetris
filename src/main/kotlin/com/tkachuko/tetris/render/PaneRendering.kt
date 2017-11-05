package com.tkachuko.tetris.render

import com.tkachuko.tetris.model.TetrisBoard

interface PaneRendering {

    fun render(board: TetrisBoard)
}