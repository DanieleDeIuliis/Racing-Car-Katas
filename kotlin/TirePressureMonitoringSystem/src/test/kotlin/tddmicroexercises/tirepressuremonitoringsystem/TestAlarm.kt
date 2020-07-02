package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Test
import org.junit.Assert.*

class TestAlarm {

    @Test
    fun `initialized alarm should be turned off`() {
        val alarm = Alarm()
        assertEquals(false, alarm.isAlarmOn)
    }

    @Test
    fun `one check should set alarm to on`() {
        val alarm = Alarm(sensor = object : ISensor {
            override fun popNextPressurePsiValue(): Double = 21.1
        })
        alarm.check()
        assertEquals(true, alarm.isAlarmOn)
    }
}
