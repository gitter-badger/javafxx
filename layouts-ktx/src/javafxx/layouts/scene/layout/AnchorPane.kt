@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import javafxx.internal.Internals.NO_GETTER
import javafxx.internal.Internals.noGetter
import javafxx.layouts.internal.ConstrainedPane
import kotlin.DeprecationLevel.ERROR

open class _AnchorPane(
    vararg children: Node
) : AnchorPane(*children), LayoutManager<Node>, ConstrainedPane {

    override val childs: MutableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    inline infix fun <N : Node> N.anchorAll(anchorAll: Double?): N = also { it.anchorAll = anchorAll }

    inline infix fun <N : Node> N.anchorTop(anchorTop: Double?): N = also { it.anchorTop = anchorTop }

    inline infix fun <N : Node> N.anchorLeft(anchorLeft: Double?): N = also { it.anchorLeft = anchorLeft }

    inline infix fun <N : Node> N.anchorBottom(anchorBottom: Double?): N = also { it.anchorBottom = anchorBottom }

    inline infix fun <N : Node> N.anchorRight(anchorRight: Double?): N = also { it.anchorRight = anchorRight }

    inline var Node.anchorAll: Double?
        @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
        set(value) {
            anchorTop = value
            anchorLeft = value
            anchorBottom = value
            anchorRight = value
        }

    inline var Node.anchorTop: Double?
        get() = getTopAnchor(this)
        set(value) = setTopAnchor(this, value)

    inline var Node.anchorLeft: Double?
        get() = getLeftAnchor(this)
        set(value) = setLeftAnchor(this, value)

    inline var Node.anchorBottom: Double?
        get() = getBottomAnchor(this)
        set(value) = setBottomAnchor(this, value)

    inline var Node.anchorRight: Double?
        get() = getRightAnchor(this)
        set(value) = setRightAnchor(this, value)
}

/** Creates a [AnchorPane]. */
fun anchorPane(
    vararg children: Node,
    init: ((@LayoutDsl _AnchorPane).() -> Unit)? = null
): AnchorPane = _AnchorPane(*children).also {
    init?.invoke(it)
}

/** Creates a [AnchorPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.anchorPane(
    vararg children: Node,
    noinline init: ((@LayoutDsl _AnchorPane).() -> Unit)? = null
): AnchorPane = javafxx.layouts.anchorPane(*children, init = init)()

/** Create a styled [AnchorPane]. */
fun styledAnchorPane(
    styleClass: String,
    vararg children: Node,
    init: ((@LayoutDsl _AnchorPane).() -> Unit)? = null
): AnchorPane = _AnchorPane(*children).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [AnchorPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledAnchorPane(
    styleClass: String,
    vararg children: Node,
    noinline init: ((@LayoutDsl _AnchorPane).() -> Unit)? = null
): AnchorPane = javafxx.layouts.styledAnchorPane(styleClass, *children, init = init)()