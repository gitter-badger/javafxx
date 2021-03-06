@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.RadioMenuItem

/** Creates a [RadioMenuItem]. */
fun radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = RadioMenuItem(text, graphic).also {
    init?.invoke(it)
}

/** Creates a [RadioMenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.radioMenuItem(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = javafxx.layouts.radioMenuItem(text, graphic, init)()

/** Create a styled [RadioMenuItem]. */
fun styledRadioMenuItem(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = RadioMenuItem(text, graphic).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [RadioMenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.styledRadioMenuItem(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl RadioMenuItem).() -> Unit)? = null
): RadioMenuItem = javafxx.layouts.styledRadioMenuItem(styleClass, text, graphic, init)()