package org.grunkspin.notificationdotteddrawable

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat

class NotificationDottedDrawable(
        context: Context,
        private val baseDrawable: Drawable
) : Drawable() {

    private val dotDrawable: Drawable = ContextCompat.getDrawable(context, R.drawable.dot)

    constructor(
            context: Context,
            @DrawableRes baseDrawableRes: Int
    ) : this(context, context.getDrawable(baseDrawableRes))

    override fun draw(canvas: Canvas?) {
        baseDrawable.bounds = bounds
        baseDrawable.draw(canvas)

        dotDrawable.setBounds(
                bounds.right - dotDrawable.intrinsicWidth,
                0,
                bounds.right,
                dotDrawable.intrinsicHeight
        )
        dotDrawable.draw(canvas)
    }

    override fun setAlpha(alpha: Int) {
        // Nothing to do.
    }

    override fun getOpacity(): Int = PixelFormat.TRANSLUCENT

    override fun setColorFilter(colorFilter: ColorFilter?) {
        // Nothing to do.
    }

}

