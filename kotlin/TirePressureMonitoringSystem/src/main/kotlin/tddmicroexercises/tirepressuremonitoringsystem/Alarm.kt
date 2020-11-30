package tddmicroexercises.tirepressuremonitoringsystem

class Alarm(private val sensor: Sensor = Sensor()) {
    private val LowPressureThreshold = 17.0
    private val HighPressureThreshold = 21.0

    var isAlarmOn = false
        internal set

    fun check(pressureValue: Double = sensor.popNextPressurePsiValue()) {
        val psiPressureValue = pressureValue

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
            isAlarmOn = true
        }
    }
}
