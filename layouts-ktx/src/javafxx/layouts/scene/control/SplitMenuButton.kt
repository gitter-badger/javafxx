@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.MenuItem
import javafx.scene.control.SplitMenuButton

open class _SplitMenuButton(
    vararg items: MenuItem
) : SplitMenuButton(*items), LayoutManager<MenuItem> {

    override val childs: MutableList<MenuItem> get() = items

    /** Creates a [MenuItem] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = menuItem(this, graphic, init)

    /** Creates a styled [MenuItem] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        styleClass: String,
        graphic: Node? = null,
        noinline init: ((@LayoutDsl MenuItem).() -> Unit)? = null
    ): MenuItem = styledMenuItem(styleClass, this, graphic, init)
}

/** Creates a [SplitMenuButton]. */
fun splitMenuButton(
    vararg items: MenuItem,
    init: ((@LayoutDsl _SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = _SplitMenuButton(*items).also {
    init?.invoke(it)
}

/** Creates a [SplitMenuButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.splitMenuButton(
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = javafxx.layouts.splitMenuButton(*items, init = init)()

/** Create a styled [SplitMenuButton]. */
fun styledSplitMenuButton(
    styleClass: String,
    vararg items: MenuItem,
    init: ((@LayoutDsl _SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = _SplitMenuButton(*items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [SplitMenuButton] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledSplitMenuButton(
    styleClass: String,
    vararg items: MenuItem,
    noinline init: ((@LayoutDsl _SplitMenuButton).() -> Unit)? = null
): SplitMenuButton = javafxx.layouts.styledSplitMenuButton(styleClass, *items, init = init)()