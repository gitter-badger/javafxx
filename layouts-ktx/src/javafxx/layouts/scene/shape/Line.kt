@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.shape.Line

/** Creates a [Line]. */
fun line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: ((@LayoutDsl Line).() -> Unit)? = null
): Line = Line(centerX, centerY, endX, endY).also {
    init?.invoke(it)
}

/** Creates a [Line] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.line(
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    noinline init: ((@LayoutDsl Line).() -> Unit)? = null
): Line = javafxx.layouts.line(centerX, centerY, endX, endY, init)()

/** Create a styled [Line]. */
fun styledLine(
    styleClass: String,
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    init: ((@LayoutDsl Line).() -> Unit)? = null
): Line = Line(centerX, centerY, endX, endY).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Line] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledLine(
    styleClass: String,
    centerX: Double = 0.0,
    centerY: Double = 0.0,
    endX: Double = 0.0,
    endY: Double = 0.0,
    noinline init: ((@LayoutDsl Line).() -> Unit)? = null
): Line = javafxx.layouts.styledLine(styleClass, centerX, centerY, endX, endY, init)()