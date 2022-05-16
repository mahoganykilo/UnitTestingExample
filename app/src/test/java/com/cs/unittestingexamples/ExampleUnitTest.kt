package com.cs.unittestingexamples

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun engineIsOff_EngineTurnsOn_WhenSwitchedOn() {
        val engine:Engine= mock()
        whenever(engine.getEngineState()) doReturn EngineState.ON
        val classUnderTest = CarImpl(engine)
        classUnderTest.switchOn()
        assertEquals(classUnderTest.checkEngineState(), EngineState.ON)
    }

    @Test
    fun engineIsOn_EngineTurnsOff_WhenSwitchedOff() {
        val engine:Engine= mock()
        whenever(engine.getEngineState()) doReturn EngineState.OFF
        val classUnderTest = CarImpl(engine)
        classUnderTest.switchOff()
        assertEquals(classUnderTest.checkEngineState(), EngineState.OFF)
    }
}