package com.example.fragmentanitest

import android.util.Log
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation

internal class EndViewTransitionAnimation(
    private val originalAnim: Animation,
    private val parent: ViewGroup
) : Animation(), Runnable {

    private var mAnimating = true

    init {
        // We must call endViewTransition() even if the animation was never run or it
        // is interrupted in a way that can't be detected easily (app put in background)
        parent.post(this)

    }

    override fun getTransformation(currentTime: Long, t: Transformation): Boolean {
        Log.d("bustle.jang", "getTransformation - 1")

        mAnimating = true

        return originalAnim.getTransformation(currentTime, t)
    }

    override fun getTransformation(
        currentTime: Long,
        outTransformation: Transformation, scale: Float
    ): Boolean {
        Log.d("bustle.jang", "getTransformation - 2")

        mAnimating = true

        return originalAnim.getTransformation(currentTime, outTransformation)
    }

    override fun run() {
        Log.d("bustle.jang", "run")
        if (mAnimating) {
            mAnimating = false
            // Called while animating, so we'll check again on next cycle
            parent.post(this)
        }
    }
}
