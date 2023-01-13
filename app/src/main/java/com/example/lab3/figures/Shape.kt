package com.example.lab3.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint

abstract class Shape(
    var startX: Float,
    var startY: Float,
    var currentX: Float,
    var currentY: Float,
) : Cloneable {
    abstract fun drawShape(canvas: Canvas?, paint: Paint)
    abstract fun setPaintStyle(paint: Paint)
    abstract fun setFillStyle(paint: Paint)
    abstract fun drawSavedShape(canvas: Canvas, paint: Paint)
    abstract fun getCoordinates():String
    var selected: Boolean = false
    protected val TOUCH_TOLERANCE = 15f
    public override fun clone(): Shape {
        return super.clone() as Shape
    }

    fun setDashEffect(paint: Paint) {
        paint.pathEffect = DashPathEffect(floatArrayOf(11f, 40f), 1f)
        paint.color = Color.RED
    }

}