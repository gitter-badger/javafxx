@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.concurrent.Task
import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.TaskProgressView

/** Creates a [TaskProgressView]. */
fun <T : Task<*>> taskProgressView(
    init: ((@LayoutDsl TaskProgressView<T>).() -> Unit)? = null
): TaskProgressView<T> = TaskProgressView<T>().also {
    init?.invoke(it)
}

/** Creates a [TaskProgressView] and add it to this [LayoutManager]. */
inline fun <T : Task<*>> LayoutManager<Node>.taskProgressView(
    noinline init: ((@LayoutDsl TaskProgressView<T>).() -> Unit)? = null
): TaskProgressView<T> = javafxx.layouts.controlsfx.taskProgressView(init)()

/** Create a styled [TaskProgressView]. */
fun <T : Task<*>> styledTaskProgressView(
    styleClass: String,
    init: ((@LayoutDsl TaskProgressView<T>).() -> Unit)? = null
): TaskProgressView<T> = TaskProgressView<T>().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [TaskProgressView] and add it to this [LayoutManager]. */
inline fun <T : Task<*>> LayoutManager<Node>.styledTaskProgressView(
    styleClass: String,
    noinline init: ((@LayoutDsl TaskProgressView<T>).() -> Unit)? = null
): TaskProgressView<T> = javafxx.layouts.controlsfx.styledTaskProgressView(styleClass, init)()