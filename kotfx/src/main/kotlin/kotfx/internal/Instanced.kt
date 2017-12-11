package kotfx.internal

/**
 * Base interface of all Kotlin DSL components in kotfx.
 * Getter [t] ensures that code logic may be defined in other public builder interfaces,
 * while the actual instance should be stored in internal class somewhere.
 */
interface Instanced<out T> {

    val t: T
}