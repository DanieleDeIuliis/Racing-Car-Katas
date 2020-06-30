package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Test
import org.junit.Assert.*
import org.junit.Ignore

class TestAlarm {

    @Test
    fun `initially the alarm is always off`() {
        val alarm = Alarm()
        assertEquals(false, alarm.isAlarmOn)
    }

    @Test
    fun `raise the alarm when the pressure measured by the sensor is under the lower threshold`() {
        val alarm = AlarmWithStubbedSensor(pressure = 0.0)
        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }

    @Test
    fun `raise the alarm when the pressure measured by the sensor is over the higher threshold`() {
        val alarm = AlarmWithStubbedSensor(pressure = 300.0)
        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }

    @Test
    fun `does not raise the alarm when the pressure measured by the sensor is within the acceptable range`() {
        val alarm = AlarmWithStubbedSensor(pressure = 20.0)
        alarm.check()
        assertFalse(alarm.isAlarmOn)
    }

    @Test @Ignore
    fun `raise the alarm when the pressure measured by the sensor is under the lower threshold 2`() {
        val alarm = Alarm(ProgrammableSensor(0.0))
        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }
}

class ProgrammableSensor(private val measuredPressure: Double): Sensor() {
    override fun popNextPressurePsiValue() = measuredPressure
}

class AlarmWithStubbedSensor(val pressure: Double) : Alarm() {
    override fun popNextPressurePsiValue(): Double {
        return pressure
    }
}
