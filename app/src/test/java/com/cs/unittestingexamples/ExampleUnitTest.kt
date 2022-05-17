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
    private val classUnderTest = CarImpl(null, battery)

    @Test
    fun engineIsMissing_AndBatteryFlat_NothingHappens_WhenSwitchedOn_UnClear() {
        whenever(battery.getCharge()) doReturn 0
        classUnderTest.switchOn()
        assertEquals(classUnderTest.checkBatteryLightOn(), true)
        assertEquals(classUnderTest.checkEngineLightOn(), true)
        assertEquals(classUnderTest.checkEngineState(), EngineState.OFF)
    }

    @Test
    fun engineIsMissing_NothingHappens_WhenSwitchedOn_Clear() {
        whenever(battery.getCharge()) doReturn 100
        classUnderTest.switchOff()
        fail()
    }

    @Test
    fun batteryIsFlat_NothingHappens_WhenSwitchedOn_Clear() {
        whenever(battery.getCharge()) doReturn 0
        classUnderTest.switchOn()
        assertEquals(classUnderTest.checkEngineState(), EngineState.OFF)
    }
}