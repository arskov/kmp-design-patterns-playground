/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package design

import kotlin.test.Test
import kotlin.test.assertTrue

class LibraryTest {
    @Test
    fun someLibraryMethodReturnsTrue() {
        val classUnderTest = Library()
        assertTrue(classUnderTest.someLibraryMethod(), "someLibraryMethod should return 'true'")
    }

    @Test
    fun exampleTest() {
        val cl1 = Pawn('a', '3')
        println(cl1)
    }
}
