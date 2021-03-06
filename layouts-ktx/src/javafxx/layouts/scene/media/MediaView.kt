@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

/** Creates a [MediaView]. */
fun mediaView(
    player: MediaPlayer? = null,
    init: ((@LayoutDsl MediaView).() -> Unit)? = null
): MediaView = MediaView(player).also {
    init?.invoke(it)
}

/** Creates a [MediaView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.mediaView(
    player: MediaPlayer? = null,
    noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null
): MediaView = javafxx.layouts.mediaView(player, init)()

/** Create a styled [MediaView]. */
fun styledMediaView(
    styleClass: String,
    player: MediaPlayer? = null,
    init: ((@LayoutDsl MediaView).() -> Unit)? = null
): MediaView = MediaView(player).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [MediaView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledMediaView(
    styleClass: String,
    player: MediaPlayer? = null,
    noinline init: ((@LayoutDsl MediaView).() -> Unit)? = null
): MediaView = javafxx.layouts.styledMediaView(styleClass, player, init)