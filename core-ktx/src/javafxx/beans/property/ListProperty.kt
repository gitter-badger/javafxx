@file:Suppress("NOTHING_TO_INLINE")

package javafxx.beans.property

import javafx.beans.property.ListProperty
import javafx.beans.property.ReadOnlyListProperty
import javafx.beans.property.ReadOnlyListWrapper
import javafx.beans.property.SimpleListProperty
import javafx.collections.ObservableList

/** Wrap this list in unmodifiable property. */
inline fun <E> ObservableList<E>?.toProperty(): ReadOnlyListProperty<E> = ReadOnlyListWrapper(this)

/** Wrap this list in modifiable property. */
inline fun <E> ObservableList<E>?.toMutableProperty(): ListProperty<E> = SimpleListProperty(this)