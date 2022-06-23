package com.linhpham.ailatrieuphu.library.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class TextViewHexagons(context: Context, attributeSet: AttributeSet) :
    AppCompatTextView(context, attributeSet) {
    private var centerY = 0f
    private var halfHeight = 0f
    private var paintBorder = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()

    init {
        paintBorder.color = Color.BLUE
        paintBorder.strokeWidth = 5f
        paintBorder.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        if (centerY == 0f) {
            centerY = height / 2f
            halfHeight = height / 2f
        }
        drawBorderPath(canvas)
        super.onDraw(canvas)
    }

    private fun drawBorderPath(canvas: Canvas?) {
        path.rewind()
        path.moveTo(x, centerY)
        path.lineTo(x + halfHeight, y)


        canvas?.drawPath(path, paintBorder)
    }
}