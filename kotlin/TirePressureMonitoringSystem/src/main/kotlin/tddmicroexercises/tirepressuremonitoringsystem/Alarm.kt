package tddmicroexercises.tirepressuremonitoringsystem

open class Alarm {
    private val LowPressureThreshold = 17.0
    private val HighPressureThreshold = 21.0

    internal var sensor = Sensor()

    var isAlarmOn = false
        internal set

    fun check(psiPressureValue: Double = popNextPressureValue()) {
        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue) {
            isAlarmOn = true
        }
    }

    protected open fun popNextPressureValue() = sensor.popNextPressurePsiValue()
}
