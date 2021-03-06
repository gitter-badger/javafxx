@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.PasswordField

/** Creates a [PasswordField]. */
fun passwordField(
    init: ((@LayoutDsl PasswordField).() -> Unit)? = null
): PasswordField = PasswordField().also {
    init?.invoke(it)
}

/** Creates a [PasswordField] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.passwordField(
    noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null
): PasswordField = javafxx.layouts.passwordField(init)()

/** Create a styled [PasswordField]. */
fun styledPasswordField(
    styleClass: String,
    init: ((@LayoutDsl PasswordField).() -> Unit)? = null
): PasswordField = PasswordField().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [PasswordField] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledPasswordField(
    styleClass: String,
    noinline init: ((@LayoutDsl PasswordField).() -> Unit)? = null
): PasswordField = javafxx.layouts.styledPasswordField(styleClass, init)()