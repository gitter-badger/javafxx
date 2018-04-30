@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text

/** Creates a [Text]. */
fun text(
    text: String? = null,
    init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = Text(text).also {
    init?.invoke(it)
}

/** Creates a [Text] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.text(
    text: String? = null,
    noinline init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = ktfx.layouts.text(text, init).add()

/** Create a styled [Text]. */
fun styledText(
    styleClass: String,
    text: String? = null,
    init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = Text(text).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Text] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledText(
    styleClass: String,
    text: String? = null,
    noinline init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = ktfx.layouts.styledText(styleClass, text, init).add()