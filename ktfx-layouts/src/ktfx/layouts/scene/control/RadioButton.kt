@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.RadioButton

/** Creates a [RadioButton]. */
fun radioButton(
    text: String? = null,
    init: ((@LayoutDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).also {
    init?.invoke(it)
}

/** Creates a [RadioButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.radioButton(
    text: String? = null,
    noinline init: ((@LayoutDsl RadioButton).() -> Unit)? = null
): RadioButton = ktfx.layouts.radioButton(text, init).add()

/** Create a styled [RadioButton]. */
fun styledRadioButton(
    styleClass: String,
    text: String? = null,
    init: ((@LayoutDsl RadioButton).() -> Unit)? = null
): RadioButton = RadioButton(text).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [RadioButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledRadioButton(
    styleClass: String,
    text: String? = null,
    noinline init: ((@LayoutDsl RadioButton).() -> Unit)? = null
): RadioButton = ktfx.layouts.styledRadioButton(styleClass, text, init).add()