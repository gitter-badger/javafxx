@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts.controlsfx

import javafx.collections.ObservableList
import javafx.scene.Node
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.CheckComboBox

/** Creates a [CheckComboBox]. */
fun <T> checkComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl CheckComboBox<T>).() -> Unit)? = null
): CheckComboBox<T> = CheckComboBox(items).also {
    init?.invoke(it)
}

/** Creates a [CheckComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.checkComboBox(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl CheckComboBox<T>).() -> Unit)? = null
): CheckComboBox<T> = ktfx.layouts.controlsfx.checkComboBox(items, init)()

/** Create a styled [CheckComboBox]. */
fun <T> styledCheckComboBox(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl CheckComboBox<T>).() -> Unit)? = null
): CheckComboBox<T> = CheckComboBox(items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [CheckComboBox] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledCheckComboBox(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl CheckComboBox<T>).() -> Unit)? = null
): CheckComboBox<T> = ktfx.layouts.controlsfx.styledCheckComboBox(styleClass, items, init)()