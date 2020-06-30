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

    @Test @Ignore
    fun `raise the alarm when the pressure measured by the sensor is under the lower threshold`() {
        val alarm = Alarm()
        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }
}
