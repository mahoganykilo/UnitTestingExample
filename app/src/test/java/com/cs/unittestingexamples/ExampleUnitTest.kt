package com.cs.unittestingexamples

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun engineIsOff_EngineTurnsOn_WhenSwitchedOn() {
        val classUnderTest = CarImpl()
        classUnderTest.switchOn()
        assertEquals(classUnderTest.checkEngineState(), EngineState.ON)
    }

    @Test
    fun engineIsOn_EngineTurnsOff_WhenSwitchedOff() {
        val classUnderTest = CarImpl()
        classUnderTest.switchOff()
        assertEquals(classUnderTest.checkEngineState(), EngineState.OFF)
    }
}