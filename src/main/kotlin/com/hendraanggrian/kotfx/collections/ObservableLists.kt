@file:JvmMultifileClass
@file:JvmName("FxCollectionsKt")
@file:Suppress("NOTHING_TO_INLINE")

package com.hendraanggrian.kotfx.collections

import javafx.collections.FXCollections
import javafx.collections.ObservableList

/** Returns an empty read-only observable list. */
inline fun <T> emptyObservableList(): ObservableList<T> = FXCollections.emptyObservableList()

inline fun <T> observableListOf(): ObservableList<T> = emptyObservableList()

inline fun <T> observableListOf(element: T): ObservableList<T> = FXCollections.singletonObservableList(element)

inline fun <T> observableListOf(vararg elements: T): ObservableList<T> = if (elements.isNotEmpty()) FXCollections.unmodifiableObservableList(elements.toMutableObservableList()) else emptyObservableList()

inline fun <T> Collection<T>.toObservableList(): ObservableList<T> = FXCollections.unmodifiableObservableList(toMutableObservableList())

inline fun <T> Array<out T>.toObservableList(): ObservableList<T> = when (size) {
    0 -> emptyObservableList()
    1 -> observableListOf(this[0])
    else -> asList().toObservableList()
}

inline fun <T> mutableObservableListOf(): ObservableList<T> = FXCollections.observableArrayList()

inline fun <T> mutableObservableListOf(vararg elements: T): ObservableList<T> = FXCollections.observableArrayList(elements.asList())

inline fun <T> Collection<T>.toMutableObservableList(): ObservableList<T> = FXCollections.observableArrayList(this)

inline fun <T> Array<out T>.toMutableObservableList(): ObservableList<T> = asList().toMutableObservableList()