package org.grunkspin.notificationdotteddrawable

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat

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
        baseDrawable.alpha = alpha
    }

    override fun getOpacity(): Int = baseDrawable.opacity

    override fun setColorFilter(colorFilter: ColorFilter?) {
        baseDrawable.colorFilter = colorFilter
    }

    override fun applyTheme(t: Resources.Theme) {
        super.applyTheme(t)
        DrawableCompat.applyTheme(baseDrawable, t)
    }

    override fun canApplyTheme(): Boolean {
        return DrawableCompat.canApplyTheme(baseDrawable)
    }

    override fun clearColorFilter() {
        super.clearColorFilter()
        baseDrawable.clearColorFilter()
    }

    override fun getAlpha(): Int {
        return DrawableCompat.getAlpha(baseDrawable)
    }

    override fun getCallback(): Callback {
        return baseDrawable.callback
    }

    override fun getChangingConfigurations(): Int {
        return baseDrawable.changingConfigurations
    }

    override fun getColorFilter(): ColorFilter {
        return DrawableCompat.getColorFilter(baseDrawable)
    }

    override fun getConstantState(): ConstantState {
        return baseDrawable.constantState
    }

    override fun getCurrent(): Drawable {
        return baseDrawable.current
    }

    override fun isStateful(): Boolean {
        return baseDrawable.isStateful
    }

    override fun getState(): IntArray {
        return baseDrawable.state
    }

    override fun setTint(tintColor: Int) {
        DrawableCompat.setTint(baseDrawable, tintColor)
    }

    override fun setTintList(tint: ColorStateList?) {
        DrawableCompat.setTintList(baseDrawable, tint)
    }

    override fun setTintMode(tintMode: PorterDuff.Mode?) {
        DrawableCompat.setTintMode(baseDrawable, tintMode)
    }

    override fun mutate(): Drawable {
        return baseDrawable.mutate()
    }
}

