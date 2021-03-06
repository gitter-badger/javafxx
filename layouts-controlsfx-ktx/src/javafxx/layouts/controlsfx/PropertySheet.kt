@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.collections.ObservableList
import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.PropertySheet

/** Creates a [PropertySheet]. */
fun propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    init: ((@LayoutDsl PropertySheet).() -> Unit)? = null
): PropertySheet = PropertySheet(items).also {
    init?.invoke(it)
}

/** Creates a [PropertySheet] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.propertySheet(
    items: ObservableList<PropertySheet.Item>? = null,
    noinline init: ((@LayoutDsl PropertySheet).() -> Unit)? = null
): PropertySheet = javafxx.layouts.controlsfx.propertySheet(items, init)()

/** Create a styled [PropertySheet]. */
fun styledPropertySheet(
    styleClass: String,
    items: ObservableList<PropertySheet.Item>? = null,
    init: ((@LayoutDsl PropertySheet).() -> Unit)? = null
): PropertySheet = PropertySheet(items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [PropertySheet] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledPropertySheet(
    styleClass: String,
    items: ObservableList<PropertySheet.Item>? = null,
    noinline init: ((@LayoutDsl PropertySheet).() -> Unit)? = null
): PropertySheet = javafxx.layouts.controlsfx.styledPropertySheet(styleClass, items, init)()