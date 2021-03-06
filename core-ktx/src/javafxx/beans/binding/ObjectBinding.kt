@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.binding

import javafx.beans.Observable
import javafx.beans.binding.Bindings.createObjectBinding
import javafx.beans.binding.Bindings.select
import javafx.beans.binding.ObjectBinding
import java.util.concurrent.Callable

/** Helper function to create a custom [ObjectBinding]. */
inline fun <T> bindingOf(
    vararg dependencies: Observable,
    noinline func: () -> T?
): ObjectBinding<T?> = createObjectBinding(Callable(func), *dependencies)

/** Creates an object binding used to get a member. */
inline fun <T> Any.select(vararg steps: String): ObjectBinding<T> = select(this, *steps)