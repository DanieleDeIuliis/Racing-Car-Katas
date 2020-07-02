package tddmicroexercises.tirepressuremonitoringsystem

import java.util.*

class MockSensor(private val pressure: Double) : Sensor() {
    override fun popNextPressurePsiValue(): Double {
        return pressure
    }
}
