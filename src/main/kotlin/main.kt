import com.tkachuko.tetris.DrawingBoard
import com.tkachuko.tetris.Game
import com.tkachuko.tetris.Movement
import com.tkachuko.tetris.TetrisBoard
import com.tkachuko.tetris.keyboard.KeyboardListener
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import org.w3c.dom.HTMLSpanElement
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    try {
        val gameCanvas =
                document.getElementById("game") as HTMLCanvasElement

        val scoreSpan =
                document.getElementById("score") as HTMLSpanElement

        val cellSize = 30
        val drawingBoard = DrawingBoard(
                gameCanvas.getContext("2d") as CanvasRenderingContext2D, scoreSpan, cellSize)

        val board = TetrisBoard.create(20, 10)
        val game = Game(drawingBoard, board)

        gameCanvas.height = board.data.size * cellSize
        gameCanvas.width = board.data[0].size * cellSize

        val gravityTimeout = 500

        KeyboardListener(
                {
                    game.start()
                    window.setInterval({ game.movementTick(Movement.Down, true) }, gravityTimeout)
                },
                { mv -> game.movementTick(mv, false) },
                { game.rotateFocusFigure() }
        ).run()

        println("Init done")
    } catch (initError: dynamic) {
        println("There was init error, skipping...")
        println(initError.toString())
    }
}