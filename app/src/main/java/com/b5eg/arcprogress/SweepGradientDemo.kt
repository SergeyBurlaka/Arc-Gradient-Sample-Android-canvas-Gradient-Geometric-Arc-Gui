package com.b5eg.arcprogress

import android.content.Context
import android.graphics.*
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout


/**
 * @author Sergey
 * @since 20.02.2019
 */
class SweepGradientDemo : FrameLayout {

    private var mWidth = 0
    private var mHeight = 0

    private fun init(context: Context, attrs: AttributeSet?, defStyle: Int) {
        //
    }

    override fun dispatchDraw(canvas: Canvas) {
        /*log_d("text-size123", " arc p: $textSize")*/

        mPaint.shader = gradient
        canvas.drawRect(rectF, mPaint)
        super.dispatchDraw(canvas)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        mHeight = h
        mWidth = w
        val s = Math.min(h, w).toFloat() - strokeWidth * 2

        rectF.set(
            w / 2 - s / 2, h / 2 - s / 2,

            w / 2 + s / 2, h / 2 + s / 2
        )
        SweepGradient(
            w / 2F,
            h / 2F,
            colors,
            positions
        ).apply {
            gradient = this
            val rotate = 270f
            val gradientMatrix = Matrix()
            gradientMatrix.preRotate(rotate, mWidth / 2F, mHeight / 2F)
            setLocalMatrix(gradientMatrix)
        }
        super.onSizeChanged(w, h, oldw, oldh)
    }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs, 0) {
        init(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(context, attrs, defStyle)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(context, attrs, defStyleRes)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = 150f.dpToPx().toInt()
        setMeasuredDimension(
            Math.max(suggestedMinimumWidth, View.resolveSize(size, widthMeasureSpec)),
            Math.max(suggestedMinimumHeight, View.resolveSize(size, heightMeasureSpec))
        )
    }

    private var rectF = RectF()
    private var mPaint = Paint().apply {
        color = default_unfinished_color
        isAntiAlias = true
        strokeWidth = this@SweepGradientDemo.strokeWidth
        style = Paint.Style.FILL
    }

    private val colors = intArrayOf(
        ContextCompat.getColor(context, R.color.progress_from_color),
        ContextCompat.getColor(context, R.color.progress_to_color)
    )
    private var positions = floatArrayOf(0.0f, 1.0f)
    private var gradient: SweepGradient? = null

    companion object {
        private val default_unfinished_color = Color.BLACK
    }

    var strokeWidth: Float = 5F
        set(value) {
            field = value
            mPaint.strokeWidth = value
        }
}