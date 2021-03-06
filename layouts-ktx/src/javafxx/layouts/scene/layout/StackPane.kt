@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane
import javafxx.layouts.internal.AlignedPane
import javafxx.layouts.internal.MarginedPane

open class _StackPane(
    vararg children: Node
) : StackPane(*children), LayoutManager<Node>, AlignedPane, MarginedPane {

    override val childs: MutableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [StackPane]. */
fun stackPane(
    vararg children: Node,
    init: ((@LayoutDsl _StackPane).() -> Unit)? = null
): StackPane = _StackPane(*children).also {
    init?.invoke(it)
}

/** Creates a [StackPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.stackPane(
    vararg children: Node,
    noinline init: ((@LayoutDsl _StackPane).() -> Unit)? = null
): StackPane = javafxx.layouts.stackPane(*children, init = init)()

/** Create a styled [StackPane]. */
fun styledStackPane(
    styleClass: String,
    vararg children: Node,
    init: ((@LayoutDsl _StackPane).() -> Unit)? = null
): StackPane = _StackPane(*children).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [StackPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledStackPane(
    styleClass: String,
    vararg children: Node,
    noinline init: ((@LayoutDsl _StackPane).() -> Unit)? = null
): StackPane = javafxx.layouts.styledStackPane(styleClass, *children, init = init)()