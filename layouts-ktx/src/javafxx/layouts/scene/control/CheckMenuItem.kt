@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckMenuItem
import javafx.scene.control.MenuItem

/** Creates a [CheckMenuItem]. */
fun checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null
): CheckMenuItem = CheckMenuItem(text, graphic).also {
    init?.invoke(it)
}

/** Creates a [CheckMenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.checkMenuItem(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null
): CheckMenuItem = javafxx.layouts.checkMenuItem(text, graphic, init)()

/** Create a styled [CheckMenuItem]. */
fun styledCheckMenuItem(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null
): CheckMenuItem = CheckMenuItem(text, graphic).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [CheckMenuItem] and add it to this [LayoutManager]. */
inline fun LayoutManager<MenuItem>.styledCheckMenuItem(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl CheckMenuItem).() -> Unit)? = null
): CheckMenuItem = javafxx.layouts.styledCheckMenuItem(styleClass, text, graphic, init)()