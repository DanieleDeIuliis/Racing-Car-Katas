package tddmicroexercises.tirepressuremonitoringsystem

class TestableAlarm(val pressure: Double): Alarm() {

    override fun popNextPressureValue(): Double {
        return pressure
    }
}
