package com.sasanebrahimi.paircolorview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class PairColorView : View {

    private var darkColor: Int = Color.GREEN
    private var lightColor: Int = Color.CYAN

    private lateinit var darkPaint: Paint
    private lateinit var lightPaint: Paint

    constructor(context: Context) : super(context) {

    }

    constructor(context: Context, attrs: AttributeSet) : super(context ,attrs) {
        initialize(context,attrs)
    }

    fun initialize(context: Context){
        //initialize(context,null)
    }

    fun initialize(context: Context, attrs: AttributeSet){
        initialize(context)
        context.obtainStyledAttributes(attrs,
            R.styleable.PairColorView, 0, 0).apply {
            try {
                darkColor = getColor(R.styleable.PairColorView_darkColor, Color.GREEN)
                lightColor = getColor(R.styleable.PairColorView_lightColor, Color.CYAN)
            } finally {
                recycle()
            }
        }

        darkPaint = Paint().apply {
            color = darkColor
        }
        lightPaint = Paint().apply {
            color = lightColor
        }
    }

    fun setColors(darkColor: Int?, lightColor: Int? ){
        darkColor?.let {
            this.darkColor = it
            darkPaint = Paint().apply {
                color = it
            }

        }
        lightColor?.let {
            this.lightColor = it
            lightPaint = Paint().apply {
                color = it
            }
        }
        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(width/2.toFloat() , height/2.toFloat(), width.toFloat()/2 , darkPaint)


        canvas?.drawArc(
            RectF(
            0f, 0f ,width.toFloat(),height.toFloat()),0f,180f, true,lightPaint)
    }

}