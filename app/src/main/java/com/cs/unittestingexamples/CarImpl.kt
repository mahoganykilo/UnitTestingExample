package com.cs.unittestingexamples

import java.lang.IllegalStateException

enum class EngineState {
    ON,
    OFF,
    MISSING
}

class Engine(state: EngineState) {
    private var engineState = state

    fun switchOn() {
        EngineState.ON
    }

    fun switchOff() {
        engineState = EngineState.OFF
    }
    fun getEngineState(): EngineState {
        return engineState
    }
}


class CarImpl: Car {
    private val engine: Engine? = null

    override fun switchOn() {
        if (engine == null) {
            return
        }
        engine.switchOn()
    }

    override fun switchOff() {
        if (engine == null) {
            return
        }
        engine.switchOff()
    }

    override fun checkEngineState(): EngineState {
        if (engine == null) {
            return EngineState.MISSING
        }
        return engine.getEngineState()
    }
}