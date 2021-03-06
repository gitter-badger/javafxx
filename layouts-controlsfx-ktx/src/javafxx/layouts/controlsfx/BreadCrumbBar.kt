@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafx.scene.control.TreeItem
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.BreadCrumbBar

/** Creates a [BreadCrumbBar]. */
fun <T> breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    init: ((@LayoutDsl BreadCrumbBar<T>).() -> Unit)? = null
): BreadCrumbBar<T> = BreadCrumbBar<T>(selectedCrumb).also {
    init?.invoke(it)
}

/** Creates a [BreadCrumbBar] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.breadCrumbBar(
    selectedCrumb: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl BreadCrumbBar<T>).() -> Unit)? = null
): BreadCrumbBar<T> = javafxx.layouts.controlsfx.breadCrumbBar(selectedCrumb, init)()

/** Create a styled [BreadCrumbBar]. */
fun <T> styledBreadCrumbBar(
    styleClass: String,
    selectedCrumb: TreeItem<T>? = null,
    init: ((@LayoutDsl BreadCrumbBar<T>).() -> Unit)? = null
): BreadCrumbBar<T> = BreadCrumbBar<T>(selectedCrumb).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [BreadCrumbBar] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledBreadCrumbBar(
    styleClass: String,
    selectedCrumb: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl BreadCrumbBar<T>).() -> Unit)? = null
): BreadCrumbBar<T> = javafxx.layouts.controlsfx.styledBreadCrumbBar(styleClass, selectedCrumb, init)()