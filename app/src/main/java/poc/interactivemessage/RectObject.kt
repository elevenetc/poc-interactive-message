package poc.interactivemessage

import android.graphics.Canvas
import poc.interactivemessage.utils.Paints

class RectObject(x: Float = 0f, y: Float = 0f, w: Float = 0f, h: Float = 0f) : MessageObject(x, y, w, h) {

    override fun onDraw(canvas: Canvas) {
        canvas.drawRect(x, y, x + width, y + height, Paints.Green)
    }
}