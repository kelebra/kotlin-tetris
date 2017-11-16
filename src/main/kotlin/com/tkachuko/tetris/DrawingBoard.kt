package com.tkachuko.tetris

import org.w3c.dom.CanvasRenderingContext2D

class DrawingBoard(private val ctx: CanvasRenderingContext2D,
                   private val cellSize: Int) {

    fun render(board: TetrisBoard) {
        ctx.clearRect(0.0, 0.0, ctx.canvas.width.toDouble(), ctx.canvas.height.toDouble());
        board.data
                .flatten()
                .filter { it.isFull() } // TODO: WTF it is needed ???
                .forEach {
                    ctx.fillStyle = it.color
                    ctx.fillRect(
                            it.x.toDouble() * cellSize,
                            it.y.toDouble() * cellSize,
                            cellSize.toDouble(),
                            cellSize.toDouble()
                    )
                }
    }
}