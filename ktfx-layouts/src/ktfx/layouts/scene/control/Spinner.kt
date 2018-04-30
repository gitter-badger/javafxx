@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Spinner

/** Creates a [Spinner]. */
fun <T> spinner(
    init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().also {
    init?.invoke(it)
}

/** Creates a [Spinner] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.spinner(
    noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = ktfx.layouts.spinner(init).add()

/** Create a styled [Spinner]. */
fun <T> styledSpinner(
    styleClass: String,
    init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = Spinner<T>().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Spinner] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledSpinner(
    styleClass: String,
    noinline init: ((@LayoutDsl Spinner<T>).() -> Unit)? = null
): Spinner<T> = ktfx.layouts.styledSpinner(styleClass, init).add()