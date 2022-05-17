package com.cs.unittestingexamples

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
        assertEquals(classUnderTest.checkBatteryLightOn(), true)
        assertEquals(classUnderTest.checkEngineLightOn(), true)
        assertEquals(classUnderTest.checkEngineState(), EngineState.OFF)
    }

    @Test
    fun engineIsMissing_NothingHappens_WhenSwitchedOn_Clear() {
        val classUnderTest = CarImpl(null, battery)
        whenever(battery.getCharge()) doReturn FULL_BATTERY
        classUnderTest.switchOff()
        assertEquals(classUnderTest.checkEngineLightOn(), true)
        assertEquals(classUnderTest.checkEngineState(), EngineState.OFF)
    }

    @Test
    fun batteryIsFlat_NothingHappens_WhenSwitchedOn_Clear() {
        val classUnderTest = CarImpl(engine, battery)
        whenever(battery.getCharge()) doReturn FLAT_BATTERY
        classUnderTest.switchOn()
        assertEquals(classUnderTest.checkEngineState(), EngineState.OFF)
    }
}