package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Test
import org.junit.Assert.*

class TestAlarm {

    @Test
    fun `Alarm is off (false) on it's initialization`() {
        val alarm = Alarm()
        assertEquals(false, alarm.isAlarmOn)
    }

    @Test
    fun `Alarm is on when pressure is 10`() {
        val alarm = Alarm()

        alarm.check(10.0)

        assertEquals(true, alarm.isAlarmOn)
    }

}
