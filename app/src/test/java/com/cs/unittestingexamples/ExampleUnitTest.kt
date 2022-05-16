package com.cs.unittestingexamples

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
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

    private val engine: Engine = mock()
    private val classUnderTest = CarImpl(engine)

    @Test
    fun engineIsOff_EngineTurnsOn_WhenCarSwitchedOn() {
        whenever(engine.getEngineState()) doReturn EngineState.ON
        classUnderTest.switchOn()
        assertEquals(classUnderTest.checkEngineState(), EngineState.ON)
    }

    @Test
    fun engineIsOn_EngineTurnsOff_WhenCarSwitchedOff() {
        whenever(engine.getEngineState()) doReturn EngineState.OFF
        classUnderTest.switchOff()
        assertEquals(classUnderTest.checkEngineState(), EngineState.OFF)
    }

    @Test(expected = IllegalStateException::class)
    fun noEngine_CarDoesntStart() {
        val noEngineCarTest = CarImpl(null)
        noEngineCarTest.switchOn()
        fail()
    }
}