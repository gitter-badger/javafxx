@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.Rating

/** Creates a [Rating]. */
fun rating(
    max: Int = 5,
    rating: Int = -1,
    init: ((@LayoutDsl Rating).() -> Unit)? = null
): Rating = Rating(max, rating).also {
    init?.invoke(it)
}

/** Creates a [Rating] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.rating(
    max: Int = 5,
    rating: Int = -1,
    noinline init: ((@LayoutDsl Rating).() -> Unit)? = null
): Rating = javafxx.layouts.controlsfx.rating(max, rating, init)()

/** Create a styled [Rating]. */
fun styledRating(
    styleClass: String,
    max: Int = 5,
    rating: Int = -1,
    init: ((@LayoutDsl Rating).() -> Unit)? = null
): Rating = Rating(max, rating).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Rating] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledRating(
    styleClass: String,
    max: Int = 5,
    rating: Int = -1,
    noinline init: ((@LayoutDsl Rating).() -> Unit)? = null
): Rating = javafxx.layouts.controlsfx.styledRating(styleClass, max, rating, init)()