package poc.interactivemessage

import android.graphics.Canvas
import poc.interactivemessage.utils.Paints

class GridObject : MessageObject() {

    override fun onDraw(canvas: Canvas) {
        val step = 50
        val w = canvas.width / step
        val h = canvas.height / step
        val centerX = canvas.width / 2f
        val centerY = canvas.height / 2f
        val height = canvas.height.toFloat()
        val width = canvas.width.toFloat()

        (0..w)
                .map { (step * it).toFloat() }
                .forEach { canvas.drawLine(it, 0f, it, height, Paints.BlackAlpha50) }


        (0..h)
                .map { (step * it).toFloat() }
                .forEach { canvas.drawLine(0f, it, width, it, Paints.BlackAlpha50) }


        canvas.drawLine(centerX, 0f, centerX, height, Paints.BlackAlpha100)
        canvas.drawLine(0f, centerY, width, centerY, Paints.BlackAlpha100)
    }

    override fun isInBounds(x: Float, y: Float): Boolean {
        return false
    }
}