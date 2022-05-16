package com.cs.unittestingexamples

enum class EngineState {
    ON,
    OFF
}

class CarImpl: Car {
    private var engineState = EngineState.OFF
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