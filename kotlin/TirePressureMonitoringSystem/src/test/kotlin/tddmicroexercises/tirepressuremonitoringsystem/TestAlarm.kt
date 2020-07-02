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
    fun `Alarm is on when pressure is under lower limit with MockSensor`() {
        val alarm = Alarm(MockSensor(16.9999))

        alarm.check()

        assertEquals(true, alarm.isAlarmOn)
    }


    @Test
    fun `Alarm is on when pressure is over upper limit with MockSensor`() {
        val alarm = Alarm(MockSensor(21.1))

        alarm.check()

        assertEquals(true, alarm.isAlarmOn)
    }

    @Test
    fun `Alarm is off when pressure is between limits with MockSensor`() {
        val alarm = Alarm(MockSensor(20.0))

        alarm.check()

        assertEquals(false, alarm.isAlarmOn)
    }
}
