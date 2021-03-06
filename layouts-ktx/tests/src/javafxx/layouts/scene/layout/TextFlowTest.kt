package javafxx.layouts.scene.layout

import javafx.scene.paint.Color.RED
import javafx.scene.text.Text
import javafxx.layouts.pane
import javafxx.layouts.textFlow
import javafxx.test.PlatformLayoutTest
import kotlin.test.assertEquals

class TextFlowTest : PlatformLayoutTest() {

    override fun newInstance() {
        assertEquals(textFlow(Text()).children.size, 1)
    }

    override fun newInstanceInitialized() {
        textFlow {
            "Hello"()
            "World" {
                fill = RED
                assertEquals(fill, RED)
            }

            assertEquals(children.size, 2)
        }
    }

    override fun withManager() {
        assertEquals(pane {
            textFlow()
        }.children.size, 1)
    }

    override fun withManagerInitialized() {
        assertEquals(pane {
            textFlow { }
        }.children.size, 1)
    }
}