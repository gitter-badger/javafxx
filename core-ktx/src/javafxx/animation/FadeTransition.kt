@file:Suppress("NOTHING_TO_INLINE")

package javafxx.animation

import javafx.animation.FadeTransition
import javafx.scene.Node
import javafx.util.Duration
import javafx.util.Duration.millis

/** Construct a [FadeTransition] that animates this [Node]. */
inline fun Node?.fadeTransition(
    duration: Duration = millis(400.0)
): FadeTransition = FadeTransition(duration, this)