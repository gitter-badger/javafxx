package javafxx.beans.binding

import javafx.scene.control.Label
import javafxx.beans.value.eq
import javafxx.beans.value.neq

class ObservableObjectBindingsTest {

    private val label = Label()

    fun eq() {
        label.alignmentProperty().isEqualTo(label.backgroundProperty())
        label.alignmentProperty() eq label.backgroundProperty()
    }

    fun neq() {
        label.alignmentProperty().isNotEqualTo(label.backgroundProperty())
        label.alignmentProperty() neq label.backgroundProperty()
    }
}