@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ToolBar

interface ItemManager {

    fun getItems(): ObservableList<Node>

    fun <T : Node> T.add(): T = apply { getItems() += this }
}

class _ToolBar(vararg items: Node) : ToolBar(*items), ItemManager

inline fun toolBar(vararg items: Node, noinline init: ((@LayoutDsl _ToolBar).() -> Unit)? = null): ToolBar = _ToolBar(*items).apply { init?.invoke(this) }
inline fun ChildManager.toolBar(vararg items: Node, noinline init: ((@LayoutDsl _ToolBar).() -> Unit)? = null): ToolBar = ktfx.layouts.toolBar(*items, init = init).add()
inline fun ItemManager.toolBar(vararg items: Node, noinline init: ((@LayoutDsl _ToolBar).() -> Unit)? = null): ToolBar = ktfx.layouts.toolBar(*items, init = init).add()
inline fun ButtonManager.toolBar(vararg items: Node, noinline init: ((@LayoutDsl _ToolBar).() -> Unit)? = null): ToolBar = ktfx.layouts.toolBar(*items, init = init).add()