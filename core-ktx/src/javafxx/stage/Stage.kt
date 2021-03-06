@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package javafxx.stage

import javafx.scene.image.Image
import javafx.stage.Stage
import javafx.stage.StageStyle
import javafx.stage.StageStyle.DECORATED
import javafxx.internal.Internals.NO_GETTER
import javafxx.internal.Internals.noGetter
import kotlin.DeprecationLevel.ERROR

/** Convenience method for overriding the stage's computed minimum width and height. */
inline var Stage.minSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMinSize(value, value)

/** Convenience method for overriding the stage's computed minimum width and height. */
inline fun Stage.setMinSize(width: Double, height: Double) {
    minWidth = width
    minHeight = height
}

/** Convenience method for overriding the stage's computed width and height. */
inline var Stage.size: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setSize(value, value)

/** Convenience method for overriding the stage's computed width and height. */
inline fun Stage.setSize(width: Double, height: Double) {
    this.width = width
    this.height = height
}

/** Convenience method for overriding the stage's computed maximum width and height. */
inline var Stage.maxSize: Double
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = setMaxSize(value, value)

/** Convenience method for overriding the stage's computed maximum width and height. */
inline fun Stage.setMaxSize(width: Double, height: Double) {
    maxWidth = width
    maxHeight = height
}

/** Removes old icons and set a new one to this stage. */
var Stage.icon: Image
    @Deprecated(NO_GETTER, level = ERROR) get() = noGetter()
    set(value) = when (icons.size) {
        0 -> icons += value
        1 -> icons[0] = value
        else -> {
            icons.clear()
            icons += value
        }
    }

/** Creates a stage with options. */
fun stage(
    title: String? = null,
    icon: Image? = null,
    style: StageStyle = DECORATED,
    init: (Stage.() -> Unit)? = null
): Stage = Stage(style).also {
    if (title != null) it.setTitle(title)
    if (icon != null) it.icon = icon
    init?.invoke(it)
}

/** Creates a stage with options. */
inline fun stage(
    style: StageStyle = DECORATED,
    noinline init: (Stage.() -> Unit)? = null
): Stage = stage(null, null, style, init)