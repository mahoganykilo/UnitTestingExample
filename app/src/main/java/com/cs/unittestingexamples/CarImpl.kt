package com.cs.unittestingexamples

import java.lang.IllegalStateException

enum class EngineState {
    ON,
    OFF
}

class BatteryImpl() : Battery{
    private val charge: Int = 100
    override fun getCharge(): Int {
        return charge
    }
}

class EngineImpl(state: EngineState): Engine {
    private var engineState = state

    override fun switchOn() {
        engineState = EngineState.ON
    }

    override fun switchOff() {
        engineState = EngineState.OFF
    }
    override fun getEngineState(): EngineState {
        return engineState
    }
}


class CarImpl(private val engine: Engine?, private val battery: Battery?): Car {

    private var batteryLight = false
    private var engineLight = false

    override fun switchOn() {
        when {
            battery == null -> batteryLight = true
            battery.getCharge() <= 0 -> batteryLight = true
            engine == null -> engineLight = true
            battery.getCharge() > 0 -> engine.switchOn()
        }
    }



    override fun switchOff() {
        if (engine == null) {
            throw IllegalStateException("No Engine!")
        }
        engine.switchOff()
    }

    override fun checkEngineState(): EngineState {
        if (engine == null) {
            throw IllegalStateException("No Engine!")
        }
        return engine.getEngineState()
    }

    override fun checkBatteryLightOn(): Boolean {
        return batteryLight
    }

    override fun checkEngineLightOn(): Boolean {
        return engineLight
    }
}