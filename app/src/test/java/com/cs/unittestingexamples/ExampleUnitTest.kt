package com.cs.unittestingexamples

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val classUnderTest = EngineImpl()
    @Test
    fun engineTurnsOn_WhenSwitchedOn() {
        classUnderTest.switchOn()
        assertEquals(classUnderTest.checkEngineState(), EngineState.ON)
    }
}