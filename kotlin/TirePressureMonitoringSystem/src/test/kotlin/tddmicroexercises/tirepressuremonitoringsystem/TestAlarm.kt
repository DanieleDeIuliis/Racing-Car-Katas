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
}

class AlarmWithStubbedSensor(val pressure: Double) : Alarm() {
    override fun popNextPressurePsiValue(): Double {
        return pressure
    }
}
