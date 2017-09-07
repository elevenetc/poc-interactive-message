package poc.interactivemessage

import android.graphics.Canvas

open class MessageObject(
        var x: Float = 0f,
        var y: Float = 0f,
        var width: Float = 0f,
        var height: Float = 0f) {

    var startDragX: Float = 0f
    var startDragY: Float = 0f

    open fun onDraw(canvas: Canvas) {

    }

    open fun onDragStart() {
        startDragX = x
        startDragY = y
    }

    open fun onDrag(startX: Float, startY: Float, pointerX: Float, pointerY: Float) {
        val diffX = pointerX - startX
        val diffY = pointerY - startY
        x = diffX + startDragX
        y = diffY + startDragY
    }

    open fun onDragEnd() {

    }

    open fun isInBounds(x: Float, y: Float): Boolean {
        return x >= this.x && y >= this.y && x <= this.x + width && y <= this.y + height
    }
}