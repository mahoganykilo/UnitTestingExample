package com.cs.unittestingexamples

import java.lang.IllegalStateException

enum class EngineState {
    ON,
    OFF
}

class Engine(state: EngineState) {
    private var engineState = state

    fun switchOn() {
        engineState = EngineState.ON
    }

    fun switchOff() {
        engineState = EngineState.OFF
    }
    fun getEngineState(): EngineState {
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