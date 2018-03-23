@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ProgressBar
import javafx.scene.control.ProgressIndicator

inline fun progressIndicator(progress: Double = ProgressBar.INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ProgressIndicator(progress).apply { init?.invoke(this) }

inline fun Manager<Node>.progressIndicator(progress: Double = ProgressBar.INDETERMINATE_PROGRESS, noinline init: ((@LayoutDsl ProgressIndicator).() -> Unit)? = null): ProgressIndicator = ktfx.layouts.progressIndicator(progress, init).add()