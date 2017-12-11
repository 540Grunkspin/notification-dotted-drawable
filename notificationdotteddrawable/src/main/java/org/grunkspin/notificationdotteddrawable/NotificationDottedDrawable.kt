package org.grunkspin.notificationdotteddrawable

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Canvas
import android.graphics.ColorFilter
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat

class NotificationDottedDrawable(
        private val context: Context,
        private val baseDrawable: Drawable,
        hasDot: Boolean = false
) : Drawable() {

    private val dotDrawable: Drawable = ContextCompat.getDrawable(context, R.drawable.dot)

    var hasDot: Boolean = hasDot
        set(value) {
            field = value
            invalidateSelf()
        }

    constructor(
            context: Context,
            @DrawableRes baseDrawableRes: Int
    ) : this(context, context.getDrawable(baseDrawableRes))

    override fun draw(canvas: Canvas?) {
        drawBaseDrawable(canvas)
        if (hasDot) drawDot(canvas)
    }

    private fun drawBaseDrawable(canvas: Canvas?) {
        baseDrawable.bounds = bounds
        baseDrawable.draw(canvas)
    }

    private fun drawDot(canvas: Canvas?) {
        dotDrawable.setBounds(
                bounds.right - dotDrawable.intrinsicWidth,
                bounds.top,
                bounds.right,
                bounds.top + dotDrawable.intrinsicHeight
        )
        dotDrawable.draw(canvas)
    }

    private val _constantState = object : Drawable.ConstantState() {
        override fun newDrawable(): Drawable {
            val base = baseDrawable.constantState.newDrawable()
            return NotificationDottedDrawable(context, base, this@NotificationDottedDrawable.hasDot)
        }

        override fun getChangingConfigurations(): Int {
            return baseDrawable.changingConfigurations
        }
    }

    override fun getConstantState(): ConstantState = _constantState

    override fun isStateful(): Boolean = baseDrawable.isStateful

    override fun setState(stateSet: IntArray?): Boolean = baseDrawable.setState(stateSet)

    override fun getState(): IntArray = baseDrawable.state

    override fun setTint(tintColor: Int) {
        DrawableCompat.setTint(baseDrawable, tintColor)
    }

    override fun setTintList(tint: ColorStateList?) {
        DrawableCompat.setTintList(baseDrawable, tint)
    }

    override fun setAlpha(alpha: Int) {
        baseDrawable.alpha = alpha
    }

    override fun getOpacity(): Int = baseDrawable.opacity

    override fun setColorFilter(colorFilter: ColorFilter?) {
        baseDrawable.colorFilter = colorFilter
    }

    override fun mutate(): Drawable {
        return NotificationDottedDrawable(context, baseDrawable.mutate(), hasDot)
    }
}

