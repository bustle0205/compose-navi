package com.example.fragmentanitest.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.animation.Animation
import android.widget.FrameLayout
import com.example.fragmentanitest.EndViewTransitionAnimation

class CustomFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    override fun startAnimation(animation: Animation?) {
        Log.d("bustle.jang", "startAnimation")

        if (animation != null) {
            val customAnim = EndViewTransitionAnimation(animation, this)

            super.startAnimation(customAnim)
        } else {
            super.startAnimation(animation)
        }
    }
}