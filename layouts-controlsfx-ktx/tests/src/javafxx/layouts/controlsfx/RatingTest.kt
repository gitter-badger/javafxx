package javafxx.layouts.controlsfx

import javafxx.test.PlatformLayoutTest
import kotlin.test.assertEquals

class RatingTest : PlatformLayoutTest() {

    override fun newInstance() {
        assertEquals(rating().max, 5)
    }

    override fun newInstanceInitialized() {
        rating {
        }
    }

    override fun withManager() {
    }

    override fun withManagerInitialized() {
    }
}