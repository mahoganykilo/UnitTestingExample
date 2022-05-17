package com.cs.unittestingexamples

interface Engine {
    fun switchOn()
    fun switchOff()
    fun getEngineState(): EngineState
}

interface Battery {
    fun getCharge(): Int
}