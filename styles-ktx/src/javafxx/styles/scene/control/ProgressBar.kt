package javafxx.styles

import javafxx.styles.internal._ProgressBarStyleBuilder

interface ProgressBarStyleBuilder {

    var indeterminateBarLength: Number

    var indeterminateBarEscape: Boolean

    var indeterminateBarFlip: Boolean

    var indeterminateBarAnimationTime: Number
}

inline fun progressBarStyle(
    prettyPrint: Boolean = false,
    builder: ProgressBarStyleBuilder .() -> Unit
): String = _ProgressBarStyleBuilder(prettyPrint).apply(builder).toString()