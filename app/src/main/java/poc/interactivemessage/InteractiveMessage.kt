package poc.interactivemessage

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewGroup

class InteractiveMessage : ViewGroup {

    constructor(context: Context) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    val objects = mutableSetOf<MessageObject>()
    var dragObject: MessageObject? = null
    var startDragX: Float = 0f
    var startDragY: Float = 0f

    init {
        setWillNotDraw(false)
        val rect = RectObject()
        rect.x = 100f
        rect.y = 100f
        rect.width = 150f
        rect.height = 150f
        objects.add(rect)
        objects.add(GridObject())
    }

    override fun onLayout(p0: Boolean, p1: Int, p2: Int, p3: Int, p4: Int) {

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val type: Int = event!!.action
        val x: Float = event.x
        val y: Float = event.y

        if (type == MotionEvent.ACTION_DOWN) {
            for (obj in objects) {
                if (obj.isInBounds(x, y)) {
                    obj.onDragStart()
                    dragObject = obj
                    startDragX = x
                    startDragY = y
                    return true
                }
            }
        } else if (type == MotionEvent.ACTION_MOVE) {
            dragObject?.onDrag(startDragX, startDragY, x, y)
            invalidate()
            return true
        } else {
            dragObject = null
            return true
        }

        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawColor(Color.RED)

        for (obj in objects) {
            obj.draw(canvas!!)
        }
    }
}