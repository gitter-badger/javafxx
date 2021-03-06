package javafxx.coroutines.collections

import javafx.collections.ObservableList
import javafxx.collections.mutableObservableListOf
import javafxx.coroutines.listener
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ObservableListTest {

    private val observable: ObservableList<String> = mutableObservableListOf()

    @Test fun listener() = observable.run {
        val s = "Hello"
        val listener = listener<String> {
            assertEquals(it.from, 0)
            assertEquals(it.to, 1)
            assertTrue(it.wasAdded())
            assertEquals(it.addedSubList.single(), s)
        }
        add(s)
        removeListener(listener)
    }
}