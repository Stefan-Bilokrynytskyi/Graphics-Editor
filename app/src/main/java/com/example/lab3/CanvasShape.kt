package com.example.lab3

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View
import com.example.lab3.MainActivity.Companion.currentFigure
import com.example.lab3.MainActivity.Companion.tableFile
import com.example.lab3.figures.*

class CanvasShape(
    context: Context,
    val strokeColor: Int,
    val fillColor: Int,
) : View(context) {
    companion object {
        var currentInd: Int = 0
    }

    private var currentX: Float = 0f
    private var currentY: Float = 0f
    private var figures = MainActivity.figures

    var paint = Paint().apply {
        isAntiAlias
        isDither
        color = strokeColor
        style = Paint.Style.FILL_AND_STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = 15f
    }

    private fun createShape(startX: Float, startY: Float, currentX: Float, currentY: Float): Shape {
        val shape = currentFigure.clone()
        shape.startX = startX
        shape.startY = startY
        shape.currentX = currentX
        shape.currentY = currentY
        return shape
    }

    protected val startColor = Color.RED


    fun setPaintShape(colorPaint: Int, stylePaint: Paint.Style) {
        this.paint.color = colorPaint
        this.paint.style = stylePaint
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        currentX = event!!.x
        currentY = event.y
        onTouchEventShape(event)
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawShapes(canvas)
    }

    private fun drawShapes(canvas: Canvas?) {
        if (figures.size > 0 && figures.size > currentInd) {
            for (e in 0 until figures.size - 1) {
                figures[e].drawSavedShape(canvas!!, paint)
            }
            figures[figures.size - 1].setDashEffect(paint)
            figures[figures.size - 1].drawShape(canvas, paint)
        } else if (figures.size > 0 && figures.size == currentInd) {
            for (e in 0 until figures.size) {
                figures[e].drawSavedShape(canvas!!, paint)
            }
        }


    }


    private fun onTouchEventShape(event: MotionEvent) {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> touchStart()
            MotionEvent.ACTION_MOVE -> touchMove()
            MotionEvent.ACTION_UP -> touchUp()
        }
    }

    protected open fun touchUp() {

        figures[currentInd].currentX = currentX
        figures[currentInd].currentY = currentY
        invalidate()
        if (tableFile.length().toInt() == 0) {
            tableFile.appendText(figures[currentInd].getCoordinates())

        } else tableFile.appendText("\n" + figures[currentInd].getCoordinates())
        currentInd++

    }

    protected open fun touchMove() {
        figures[currentInd].currentX = currentX
        figures[currentInd].currentY = currentY
        invalidate()
    }

    protected open fun touchStart() {
        setPaintShape(startColor, Paint.Style.STROKE)
        figures.add(currentInd, createShape(currentX, currentY, currentX, currentY))

        figures[currentInd].setDashEffect(paint)
    }


}