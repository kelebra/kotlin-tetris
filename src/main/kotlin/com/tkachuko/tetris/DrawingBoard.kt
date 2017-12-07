package com.tkachuko.tetris

import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLSpanElement

class DrawingBoard(private val ctx: CanvasRenderingContext2D,
                   private val score: HTMLSpanElement,
                   private val cellSize: Int) {

    fun render(board: TetrisBoard, score: Int) {
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
        this.score.innerText = ("Score: " + score)
    }
}