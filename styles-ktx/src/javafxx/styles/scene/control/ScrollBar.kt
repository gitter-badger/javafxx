package javafxx.styles

import javafx.geometry.Orientation
import javafxx.styles.internal._ScrollBarStyleBuilder

interface ScrollBarStyleBuilder {

    var orientation: Orientation

    var blockIncrement: Number

    var unitIncrement: Number
}

inline fun scrollBarStyle(
    prettyPrint: Boolean = false,
    builder: ScrollBarStyleBuilder .() -> Unit
): String = _ScrollBarStyleBuilder(prettyPrint).apply(builder).toString()