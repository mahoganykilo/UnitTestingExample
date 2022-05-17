package com.cs.unittestingexamples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.lang.IllegalStateException

enum class EngineState {
    ON,
    OFF,
    MISSING
}

class EngineImpl(state: EngineState, cylinders: Int, valves: String, capacity: Double): Engine {
    private var engineState: MutableLiveData<EngineState> = MutableLiveData(EngineState.OFF)

    override fun switchOn() {
        engineState.value = EngineState.ON
    }

    override fun switchOff() {
        engineState.value = EngineState.OFF
    }
    override fun getEngineState(): EngineState {
        return engineState.value ?: EngineState.MISSING
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