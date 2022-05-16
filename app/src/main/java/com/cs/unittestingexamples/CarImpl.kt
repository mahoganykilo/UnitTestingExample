package com.cs.unittestingexamples

enum class EngineState {
    ON,
    OFF
}

class CarImpl(state: EngineState): Car {
    private var engineState = state
    override fun switchOn() {
        EngineState.ON
    }

    override fun switchOff() {
        engineState = EngineState.OFF
    }

    override fun checkEngineState(): EngineState {
        return engineState
    }
}