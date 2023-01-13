package com.example.lab3.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import java.lang.Math.abs

class Section(
    startX: Float,
    startY: Float,
    currentX: Float,
    currentY: Float,

    ) : Line(startX, startY, currentX, currentY) {

    override fun drawShape(canvas: Canvas?, paint: Paint) {
        val dx = abs(currentX - startX)
        val dy = abs(currentY - startY)
        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {

            canvas?.drawLine(startX,startY,currentX,currentY, paint)
            canvas?.drawCircle(startX,startY,60f, paint)
            canvas?.drawCircle(currentX,currentY,60f, paint)
        }
    }
    override fun setPaintStyle(paint: Paint) {
        paint.pathEffect = null
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.color = if (selected) Color.rgb(189, 72, 4) else Color.BLACK
    }

    override fun setFillStyle(paint: Paint) {
        paint.pathEffect = null
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
    }

    override fun drawSavedShape(canvas: Canvas, paint: Paint) {
        setFillStyle(paint)
        drawShape(canvas, paint)
        setPaintStyle(paint)
        drawShape(canvas, paint)
    }
    override fun getCoordinates(): String {
        return "Відрізок A(${startX.toInt()}, ${startY.toInt()}) | B(${currentX.toInt()}, ${currentY.toInt()})"
    }
}
