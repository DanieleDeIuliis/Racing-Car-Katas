package tddmicroexercises.tirepressuremonitoringsystem

class Alarm(private val sensor: Sensor = Sensor()) {
    private val LowPressureThreshold = 17.0
    private val HighPressureThreshold = 21.0

    var isAlarmOn = false
        get() = check()
        internal set

    fun check(): Boolean{
        val psiPressureValue = sensor.popNextPressurePsiValue()
        return psiPressureValue < LowPressureThreshold || psiPressureValue > HighPressureThreshold

    }
}
