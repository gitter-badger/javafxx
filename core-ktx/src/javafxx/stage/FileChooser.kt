@file:Suppress("NOTHING_TO_INLINE")

package javafxx.stage

import javafx.stage.FileChooser
import javafx.stage.FileChooser.ExtensionFilter

/**
 * Build a file chooser dialog with Kotlin DSL.
 *
 * @param title title of the dialog.
 * @param filters expected file extensions.
 * @param init custom initialization block.
 */
fun fileChooser(
    title: String? = null,
    vararg filters: ExtensionFilter,
    init: (FileChooser.() -> Unit)? = null
): FileChooser = FileChooser().also {
    if (title != null) it.title = title
    if (filters.isNotEmpty()) it.extensionFilters += filters
    init?.invoke(it)
}

/**
 * Build a file chooser dialog with Kotlin DSL.
 *
 * @param filters expected file extensions.
 * @param init custom initialization block.
 */
inline fun fileChooser(
    vararg filters: ExtensionFilter,
    noinline init: (FileChooser.() -> Unit)? = null
): FileChooser = fileChooser(null, *filters, init = init)