@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.chart.Axis
import javafx.scene.chart.StackedAreaChart
import javafx.scene.chart.XYChart.Series
import javafxx.collections.mutableObservableListOf

/** Creates a [StackedAreaChart]. */
fun <X, Y> stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null
): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).also {
    init?.invoke(it)
}

/** Creates a [StackedAreaChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.stackedAreaChart(
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null
): StackedAreaChart<X, Y> = javafxx.layouts.stackedAreaChart(x, y, data, init)()

/** Create a styled [StackedAreaChart]. */
fun <X, Y> styledStackedAreaChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null
): StackedAreaChart<X, Y> = StackedAreaChart(x, y, data).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [StackedAreaChart] and add it to this [LayoutManager]. */
inline fun <X, Y> LayoutManager<Node>.styledStackedAreaChart(
    styleClass: String,
    x: Axis<X>,
    y: Axis<Y>,
    data: ObservableList<Series<X, Y>> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl StackedAreaChart<X, Y>).() -> Unit)? = null
): StackedAreaChart<X, Y> = javafxx.layouts.styledStackedAreaChart(styleClass, x, y, data, init)()