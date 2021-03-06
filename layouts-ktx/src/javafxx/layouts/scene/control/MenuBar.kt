@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.Menu
import javafx.scene.control.MenuBar
import javafx.scene.control.MenuItem

class _MenuBar(
    vararg menus: Menu
) : MenuBar(*menus), LayoutManager<Menu> {

    override val childs: MutableList<Menu> get() = menus

    /** Creates a [Menu] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        graphic: Node? = null,
        vararg items: MenuItem,
        noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null
    ): Menu = menu(this, graphic, *items, init = init)()

    /** Creates a styled [Menu] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        styleClass: String,
        graphic: Node? = null,
        vararg items: MenuItem,
        noinline init: ((@LayoutDsl _Menu).() -> Unit)? = null
    ): Menu = styledMenu(styleClass, this, graphic, *items, init = init)()
}

/** Creates a [MenuBar]. */
fun menuBar(
    vararg menus: Menu,
    init: ((@LayoutDsl _MenuBar).() -> Unit)? = null
): MenuBar = _MenuBar(*menus).also {
    init?.invoke(it)
}

/** Creates a [MenuBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.menuBar(
    vararg menus: Menu,
    noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null
): MenuBar = javafxx.layouts.menuBar(*menus, init = init)()

/** Create a styled [MenuBar]. */
fun styledMenuBar(
    styleClass: String,
    vararg menus: Menu,
    init: ((@LayoutDsl _MenuBar).() -> Unit)? = null
): MenuBar = _MenuBar(*menus).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [MenuBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledMenuBar(
    styleClass: String,
    vararg menus: Menu,
    noinline init: ((@LayoutDsl _MenuBar).() -> Unit)? = null
): MenuBar = javafxx.layouts.styledMenuBar(styleClass, *menus, init = init)()