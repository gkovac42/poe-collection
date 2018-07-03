package com.example.goran.poecollection.util

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.ScaleGestureDetector

class ZoomTextView : AppCompatTextView {
    private var mScaleDetector: ScaleGestureDetector? = null

    private var mScaleFactor = 1f
    private var defaultSize: Float = 0.toFloat()
    private var zoomLimit = 3.0f


    constructor(context: Context) : super(context) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize()
    }

    private fun initialize() {
        defaultSize = textSize
        mScaleDetector = ScaleGestureDetector(context, ScaleListener())

    }

    fun setZoomLimit(zoomLimit: Float) {
        this.zoomLimit = zoomLimit
    }

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        super.onTouchEvent(ev)
        mScaleDetector!!.onTouchEvent(ev)
        return true
    }

    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            mScaleFactor *= detector.scaleFactor
            mScaleFactor = Math.max(1.0f, Math.min(mScaleFactor, zoomLimit))
            setTextSize(TypedValue.COMPLEX_UNIT_PX, defaultSize * mScaleFactor)
            return true
        }
    }
}
