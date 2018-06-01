@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.canvas.Canvas

/** Creates a [Canvas]. */
fun canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    init: ((@LayoutDsl Canvas).() -> Unit)? = null
): Canvas = Canvas(width, height).also {
    init?.invoke(it)
}

/** Creates a [Canvas] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.canvas(
    width: Double = 0.0,
    height: Double = 0.0,
    noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null
): Canvas = ktfx.layouts.canvas(width, height, init).add()

/** Create a styled [Canvas]. */
fun styledCanvas(
    styleClass: String,
    width: Double = 0.0,
    height: Double = 0.0,
    init: ((@LayoutDsl Canvas).() -> Unit)? = null
): Canvas = Canvas(width, height).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Canvas] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledCanvas(
    styleClass: String,
    width: Double = 0.0,
    height: Double = 0.0,
    noinline init: ((@LayoutDsl Canvas).() -> Unit)? = null
): Canvas = ktfx.layouts.styledCanvas(styleClass, width, height, init).add()