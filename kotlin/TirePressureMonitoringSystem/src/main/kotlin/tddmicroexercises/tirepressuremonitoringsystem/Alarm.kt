package tddmicroexercises.tirepressuremonitoringsystem

open class Alarm(private val sensor: Sensor = SimulatedSensor()) {
    private val LowPressureThreshold = 17.0
    private val HighPressureThreshold = 21.0

    var isAlarmOn = false
        internal set

    fun check() {
        val psiPressureValue = sensor.popNextPressurePsiValue()

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
            isAlarmOn = true
        }
    }

}
