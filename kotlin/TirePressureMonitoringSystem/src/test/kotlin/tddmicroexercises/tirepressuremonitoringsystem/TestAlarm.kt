package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Test
import org.junit.Assert.*

class TestAlarm {

    @Test
    fun `initially the alarm is always off`() {
        val alarm = Alarm()
        assertEquals(false, alarm.isAlarmOn)
    }

    @Test
    fun `raise the alarm when the pressure measured by the sensor is under the lower threshold`() {
        val alarm = Alarm(ProgrammableSensor(0.0))
        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }

    @Test
    fun `raise the alarm when the pressure measured by the sensor is over the higher threshold`() {
        val alarm = Alarm(ProgrammableSensor(measuredPressure = 300.0))
        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }

    @Test
    fun `does not raise the alarm when the pressure measured by the sensor is within the acceptable range`() {
        val alarm = Alarm(ProgrammableSensor(measuredPressure = 20.0))
        alarm.check()
        assertFalse(alarm.isAlarmOn)
    }
}

class ProgrammableSensor(private val measuredPressure: Double): Sensor {
    override fun popNextPressurePsiValue() = measuredPressure
}
