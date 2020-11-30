package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Test
import org.junit.Assert.*

class TestAlarm {

    @Test
    fun `return false when temperature is in range`() {
        val alarm = Alarm(TestSensor(20.0))
        assertFalse(alarm.isAlarmOn)
    }

    @Test
    fun `return true when temperature is greater than maximum`() {
        val alarm = Alarm(TestSensor(21.1))
        assertTrue( alarm.isAlarmOn)
    }

    @Test
    fun `return false when temperature is lower than minimum`() {
        val alarm = Alarm(TestSensor(16.9))
        assertTrue(alarm.isAlarmOn)
    }
}
