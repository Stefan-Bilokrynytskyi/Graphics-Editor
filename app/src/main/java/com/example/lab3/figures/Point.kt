package com.example.lab3.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint


class Point(
    startX: Float,
    startY: Float,
    currentX: Float,
    currentY: Float,

) : Shape(startX, startY, currentX, currentY) {

    override fun drawShape(canvas: Canvas?, paint: Paint) {
        canvas?.drawPoint(startX, startY,paint)
    }
    override fun setPaintStyle(paint: Paint) {
        paint.pathEffect = null
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.color = if (selected) Color.rgb(189, 72, 4) else Color.BLACK
    }

    override fun setFillStyle(paint: Paint) { // прийняття об'єкту
        paint.pathEffect = null
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
    }

    override fun drawSavedShape(canvas: Canvas, paint: Paint) {
        setPaintStyle(paint) // передача прийнатого об'єкту paint в функцію setFillStyle
        drawShape(canvas, paint)
    }
    override fun getCoordinates(): String {
        return "Точка (${startX.toInt()}, ${startY.toInt()})"
    }
}