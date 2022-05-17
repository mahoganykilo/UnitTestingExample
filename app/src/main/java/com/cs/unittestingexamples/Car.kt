package com.cs.unittestingexamples

interface Car {

    fun switchOn()
    fun switchOff()
    fun checkEngineState(): EngineState
    fun checkBatteryLightOn(): Boolean
    fun checkEngineLightOn(): Boolean

}