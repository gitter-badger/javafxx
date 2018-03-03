@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

import javafx.scene.control.TreeTableView

inline fun <S> TreeTableView<S>.rowFactory(
    noinline rowFactory: TreeTableRowBuilder<S>.() -> Unit
) = setRowFactory { rowFactory.build() }