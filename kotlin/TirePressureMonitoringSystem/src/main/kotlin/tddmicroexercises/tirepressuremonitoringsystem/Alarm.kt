package tddmicroexercises.tirepressuremonitoringsystem

class Alarm(private val pressureSensor: Sensor) {
    private val LowPressureThreshold = 17.0
    private val HighPressureThreshold = 21.0

    var isAlarmOn: Boolean = false
        get() = check()
        internal set

    fun check(): Boolean {
        val psiPressureValue = pressureSensor.popNextPressurePsiValue()

        return psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue
    }
}
