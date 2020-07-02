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
    fun `Alarm is on when pressure is under lower limit`() {
        val alarm = Alarm()

        alarm.check(16.9999999)

        assertEquals(true, alarm.isAlarmOn)
    }

    @Test
    fun `Alarm is on when pressure is over upper limit`() {
        val alarm = Alarm()

        alarm.check(21.0000001)

        assertEquals(true, alarm.isAlarmOn)
    }

    @Test
    fun `Alarm is off when pressure is between limits`() {
        val alarm = Alarm()

        alarm.check(20.0)

        assertEquals(false, alarm.isAlarmOn)
    }

    @Test
    fun `Alarm is on when pressure is under lower limit with TestAlarm`() {
        val alarm = TestableAlarm(16.9999)

        alarm.check()

        assertEquals(true, alarm.isAlarmOn)
    }


}
