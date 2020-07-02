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
    fun `Alarm is on when pressure is under lower limit with TestAlarm`() {
        val alarm = TestableAlarm(16.9999)

        alarm.check()

        assertEquals(true, alarm.isAlarmOn)
    }


    @Test
    fun `Alarm is on when pressure is over upper limit with TestAlarm`() {
        val alarm = TestableAlarm(21.1)

        alarm.check()

        assertEquals(true, alarm.isAlarmOn)
    }

    @Test
    fun `Alarm is off when pressure is between limits with TestAlarm`() {
        val alarm = TestableAlarm(20.0)

        alarm.check()

        assertEquals(false, alarm.isAlarmOn)
    }
}
