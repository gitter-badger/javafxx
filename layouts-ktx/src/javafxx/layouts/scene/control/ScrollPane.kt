@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane

open class _ScrollPane(
    content: Node?
) : ScrollPane(content), LayoutManager<Node> {

    override operator fun <T : Node> T.invoke(): T = also { content = it }
}

/** Creates a [ScrollPane]. */
fun scrollPane(
    content: Node? = null,
    init: ((@LayoutDsl _ScrollPane).() -> Unit)? = null
): ScrollPane = _ScrollPane(content).also {
    init?.invoke(it)
}

/** Creates a [ScrollPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.scrollPane(
    content: Node? = null,
    noinline init: ((@LayoutDsl _ScrollPane).() -> Unit)? = null
): ScrollPane = javafxx.layouts.scrollPane(content, init)()

/** Create a styled [ScrollPane]. */
fun styledScrollPane(
    styleClass: String,
    content: Node? = null,
    init: ((@LayoutDsl _ScrollPane).() -> Unit)? = null
): ScrollPane = _ScrollPane(content).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ScrollPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledScrollPane(
    styleClass: String,
    content: Node? = null,
    noinline init: ((@LayoutDsl _ScrollPane).() -> Unit)? = null
): ScrollPane = javafxx.layouts.styledScrollPane(styleClass, content, init)()