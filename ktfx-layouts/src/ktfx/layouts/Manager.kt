package ktfx.layouts

/** Base interface for all layout managers. */
interface Manager<in E> {

    /** Add item to this manager, returning the item added. */
    fun <T : E> T.add(): T
}