@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.PrefixSelectionChoiceBox

/** Creates a [PrefixSelectionChoiceBox]. */
fun <T> prefixSelectionChoiceBox(
    init: ((@LayoutDsl PrefixSelectionChoiceBox<T>).() -> Unit)? = null
): PrefixSelectionChoiceBox<T> = PrefixSelectionChoiceBox<T>().also {
    init?.invoke(it)
}

/** Creates a [PrefixSelectionChoiceBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.prefixSelectionChoiceBox(
    noinline init: ((@LayoutDsl PrefixSelectionChoiceBox<T>).() -> Unit)? = null
): PrefixSelectionChoiceBox<T> = javafxx.layouts.controlsfx.prefixSelectionChoiceBox(init)()

/** Create a styled [PrefixSelectionChoiceBox]. */
fun <T> styledPrefixSelectionChoiceBox(
    styleClass: String,
    init: ((@LayoutDsl PrefixSelectionChoiceBox<T>).() -> Unit)? = null
): PrefixSelectionChoiceBox<T> = PrefixSelectionChoiceBox<T>().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [PrefixSelectionChoiceBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledPrefixSelectionChoiceBox(
    styleClass: String,
    noinline init: ((@LayoutDsl PrefixSelectionChoiceBox<T>).() -> Unit)? = null
): PrefixSelectionChoiceBox<T> = javafxx.layouts.controlsfx.styledPrefixSelectionChoiceBox(styleClass, init)()