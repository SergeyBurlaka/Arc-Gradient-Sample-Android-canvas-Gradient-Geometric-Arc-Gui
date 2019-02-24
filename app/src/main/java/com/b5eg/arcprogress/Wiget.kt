package com.b5eg.arcprogress

import android.content.Context
import android.content.res.Resources
import android.support.v4.app.Fragment
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import java.text.DecimalFormat

/**
 * @author Sergey
 * @since 20.02.2019
 */

/*fun View.convertDpToPixel(dp: Float): Float {
    return dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}

fun View.convertPixelsToDp(px: Float): Float {
    return px / (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
}*/

fun ViewGroup.inflate(id: Int) = ((context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
    id,
    this,
    false
))!!

fun Float.formatValue() = DecimalFormat("#.#").format(this)!!

fun Float.pxToDp(): Float {
    return (this / Resources.getSystem().displayMetrics.density)
}

fun Float.dpToPx(): Float {
    return (this * Resources.getSystem().displayMetrics.density)
}

fun Fragment.getFloat(id: Int) = TypedValue().run {
    resources.getValue(id, this, true)
    this.float
}