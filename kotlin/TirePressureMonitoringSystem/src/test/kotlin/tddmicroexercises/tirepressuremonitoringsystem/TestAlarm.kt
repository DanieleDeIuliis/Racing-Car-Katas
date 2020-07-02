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
    fun `one check should set alarm to on with high pressure`() {
        val alarm = Alarm(sensor = object : Sensor {
            override fun popNextPressurePsiValue(): Double = 21.1
        })
        alarm.check()
        assertEquals(true, alarm.isAlarmOn)
    }

    @Test
    fun `one check should set alarm to on with low pressure`() {
        val alarm = Alarm(sensor = object : Sensor {
            override fun popNextPressurePsiValue(): Double = 0.0
        })
        alarm.check()
        assertEquals(true, alarm.isAlarmOn)
    }
}
