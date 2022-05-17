package com.cs.unittestingexamples

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test
import org.mockito.kotlin.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val battery: Battery = mock()
    private val engine: Engine = mock()
    companion object{
        const val FLAT_BATTERY = 0
        const val FULL_BATTERY = 100
    }

    @Test
    fun engineIsMissing_AndBatteryFlat_NothingHappens_WhenSwitchedOn_UnClear() {
        val classUnderTest = CarImpl(null, battery)
        whenever(battery.getCharge()) doReturn FLAT_BATTERY
        classUnderTest.switchOn()
        assertEquals(true, classUnderTest.checkBatteryLightOn())
        assertEquals(true, classUnderTest.checkEngineLightOn())
        assertEquals(EngineState.MISSING, classUnderTest.checkEngineState())
        verify(battery).getCharge()
    }

    @Test
    fun engineIsMissing_NothingHappens_WhenSwitchedOn_Clear() {
        val classUnderTest = CarImpl(null, battery)
        whenever(battery.getCharge()) doReturn FULL_BATTERY
        classUnderTest.switchOn()
        assertEquals(true, classUnderTest.checkEngineLightOn())
        assertEquals(EngineState.MISSING, classUnderTest.checkEngineState())
        verify(battery).getCharge()
    }

    @Test
    fun batteryIsFlat_NothingHappens_WhenSwitchedOn_Clear() {
        val classUnderTest = CarImpl(engine, battery)
        whenever(engine.getEngineState()) doReturn EngineState.OFF
        whenever(battery.getCharge()) doReturn FLAT_BATTERY
        classUnderTest.switchOn()
        assertEquals(EngineState.OFF, classUnderTest.checkEngineState())
        assertEquals(true, classUnderTest.checkBatteryLightOn())
        verify(engine).getEngineState()
    }
}