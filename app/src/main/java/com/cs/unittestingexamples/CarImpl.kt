package com.cs.unittestingexamples

import java.lang.IllegalStateException

enum class EngineState {
    ON,
    OFF
}

class EngineImpl(state: EngineState, cylinders: Int, valves: String, capacity: Double): Engine {
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


class CarImpl(private val engine: Engine?): Car {

    override fun switchOn() {
        if (engine == null) {
            throw IllegalStateException("No Engine!")
        }
        engine.switchOn()
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
}