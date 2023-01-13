package com.example.lab3.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import java.lang.Math.abs

class Cube(
    startX: Float,
    startY: Float,
    currentX: Float,
    currentY: Float,

    ) : Rectangle(startX, startY, currentX, currentY) {

    override fun drawShape(canvas: Canvas?, paint: Paint) {
        val deltaX = abs(startX - currentX)
        val deltaY = abs(startY - currentY)
        val max = deltaX.coerceAtLeast(deltaY)
        currentX = if (startX < currentX) startX + max else startX - max
        currentY = if (startY < currentY) startY + max else startY - max

        val dif = abs(startX - currentX)/4

        val right : Float; val left : Float; val bottom : Float; val top : Float
        val right2 : Float; val left2 : Float;val bottom2 : Float ; val top2 : Float

        if (startX < currentX && startY > currentY) {
            right = currentX - dif; left = startX; bottom = startY; top = currentY + dif
            right2 = currentX; left2 = startX + dif ; bottom2 = startY - dif; top2 = currentY

        } else if (startX < currentX && startY < currentY) {
            right = currentX; left = startX + dif; bottom = currentY; top = startY + dif
            right2 = startX + dif * 3; left2 = startX; bottom2 = currentY - dif; top2 = startY

        } else if (startX > currentX && startY > currentY) {
            right = startX; left = currentX + dif; bottom = startY; top = currentY + dif
            right2 = startX - dif; left2 = currentX; bottom2 = startY - dif; top2 = currentY

        } else {
            right = startX - dif; left = currentX; bottom = currentY; top = startY + dif
            right2 = startX; left2 = currentX + dif; bottom2 = currentY - dif; top2 = startY

        }
        canvas?.drawRect(left, top, right, bottom, paint)
        canvas?.drawRect(left2, top2, right2, bottom2, paint)
        canvas?.drawLine(left, top, left2, top2, paint)
        canvas?.drawLine(left, bottom, left2, bottom2, paint)
        canvas?.drawLine(right, bottom, right2, bottom2, paint)
        canvas?.drawLine(right, top, right2, top2, paint)
    }

    override fun setPaintStyle(paint: Paint) {
        paint.pathEffect = null
        paint.color = Color.BLACK
        paint.style = Paint.Style.STROKE
        paint.color = if (selected) Color.rgb(189, 72, 4) else Color.BLACK
    }

    override fun setFillStyle(paint: Paint) {
        paint.pathEffect = null
        paint.color = Color.TRANSPARENT
        paint.style = Paint.Style.FILL
    }

    override fun drawSavedShape(canvas: Canvas, paint: Paint) {
        setPaintStyle(paint)
        drawShape(canvas, paint)
    }

    override fun getCoordinates(): String {
        return "Куб A(${startX.toInt()}, ${startY.toInt()}) | B(${currentX.toInt()}, ${currentY.toInt()})"
    }
}