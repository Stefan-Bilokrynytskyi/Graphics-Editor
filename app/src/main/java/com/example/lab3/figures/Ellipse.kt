package com.example.lab3.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint


class Ellipse (
    startX: Float,
    startY: Float,
    currentX: Float,
    currentY: Float,
    ) : Shape(startX, startY, currentX, currentY) {

    override fun drawShape(canvas: Canvas?, paint: Paint) {
        canvas?.drawOval(startX, startY, currentX, currentY, paint)
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
        return "Еліпс A(${startX.toInt()}, ${startY.toInt()}) | B(${currentX.toInt()}, ${currentY.toInt()})"
    }
}
