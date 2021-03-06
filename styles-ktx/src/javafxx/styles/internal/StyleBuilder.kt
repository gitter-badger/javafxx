package javafxx.styles.internal

import javafx.geometry.Insets
import javafx.scene.paint.Color
import java.lang.Character.isUpperCase

open class StyleBuilder(private val prettyPrint: Boolean) {

    protected val map: MutableMap<String, Any> = mutableMapOf()

    override fun toString(): String = buildString {
        map.forEach { key, value ->
            "${key.toKey()}: ${value.toValue()};".let { line ->
                when {
                    prettyPrint -> appendln(line)
                    else -> append("$line ")
                }
            }
        }
    }

    private companion object {

        fun String.toKey() = when (this) {
            "visibility" -> this
            else -> "-fx-${map { if (isUpperCase(it)) "-${it.toLowerCase()}" else "$it" }.joinToString("")}"
        }

        fun Any.toValue(): String = when (this) {
            is String -> this
            is Color -> "#%02X%02X%02X".format((red * 255).toInt(), (green * 255).toInt(), (blue * 255).toInt())
            is Insets -> "$top $right $bottom $left"
            else -> toString()
        }.toLowerCase()
    }
}