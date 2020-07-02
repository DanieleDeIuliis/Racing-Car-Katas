package tddmicroexercises.tirepressuremonitoringsystem

class Alarm(internal var sensor: Sensor = FakeSensor()) {
    private val LowPressureThreshold = 17.0
    private val HighPressureThreshold = 21.0

    var isAlarmOn = false
        internal set

    fun check() {
        val psiPressureValue = sensor.popNextPressurePsiValue()

        if (psiPressureValue < LowPressureThreshold ) {
            isAlarmOn = true
        }
        if( HighPressureThreshold < psiPressureValue) {
            isAlarmOn = true
        }
    }
}
