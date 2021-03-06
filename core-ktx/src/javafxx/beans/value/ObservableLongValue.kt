@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.value

import javafx.beans.value.ObservableLongValue
import kotlin.reflect.KProperty

inline operator fun ObservableLongValue.getValue(thisRef: Any?, property: KProperty<*>): Long = get()