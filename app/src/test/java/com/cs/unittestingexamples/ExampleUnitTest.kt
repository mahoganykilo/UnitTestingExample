package com.cs.unittestingexamples

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val classUnderTest = CarImpl()

    @Test
    fun engineIsOff_EngineTurnsOn_WhenSwitchedOn() {
        classUnderTest.switchOn()
        assertEquals(classUnderTest.checkEngineState(), EngineState.ON)
    }

    @Test
    fun engineIsOn_EngineTurnsOff_WhenSwitchedOff() {
        classUnderTest.switchOff()
        assertEquals(classUnderTest.checkEngineState(), EngineState.OFF)
    }

    @Test
    fun engineMissing_NothingHappens_WhenSwitchedOn() {
        classUnderTest.switchOn()
        assertEquals(classUnderTest.checkEngineState(), EngineState.MISSING)
    }
}