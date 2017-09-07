package poc.interactivemessage

import android.graphics.*
import poc.interactivemessage.utils.Paints


class TextObject(private var text: String = "") : MessageObject() {

    val bounds: Rect = Rect()
    val paint = Paint()
    var xz: Float = 200f
    var trans: Float = 0f
    val matrix = Matrix()
    val linearGradient = LinearGradient(200f, 200f, 250f, 250f, Color.BLACK, Color.WHITE, Shader.TileMode.CLAMP)

    init {

        paint.maskFilter = BlurMaskFilter(10f, BlurMaskFilter.Blur.NORMAL)


        linearGradient.getLocalMatrix(matrix)
        paint.shader = linearGradient
        //paint.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas) {
        Paints.WhiteTextLarge.getTextBounds(text, 0, text.length, bounds)
        val centerX = canvas.width / 2f
        val centerY = canvas.height / 2f
        canvas.drawText(text, centerX - bounds.width() / 2, centerY - bounds.height() / 2, Paints.WhiteTextLarge)

        canvas.drawCircle(xz, 200f, 100f, paint)
        matrix.postTranslate(trans, 0f)
        linearGradient.setLocalMatrix(matrix)
        xz++
        trans++
    }
}