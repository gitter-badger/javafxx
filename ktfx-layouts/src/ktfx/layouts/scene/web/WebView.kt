@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.web.WebView

/** Creates a [WebView]. */
fun webView(
    init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = WebView().also {
    init?.invoke(it)
}

/** Creates a [WebView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.webView(
    noinline init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = ktfx.layouts.webView(init).add()

/** Create a styled [WebView]. */
fun styledWebView(
    styleClass: String,
    init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = WebView().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [WebView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledWebView(
    styleClass: String,
    noinline init: ((@LayoutDsl WebView).() -> Unit)? = null
): WebView = ktfx.layouts.styledWebView(styleClass, init).add()