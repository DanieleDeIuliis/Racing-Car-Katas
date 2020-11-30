package tddmicroexercises.tirepressuremonitoringsystem

class TestSensor(private val mockValue: Double): Sensor() {
    override fun popNextPressurePsiValue(): Double {
        return mockValue
    }
}