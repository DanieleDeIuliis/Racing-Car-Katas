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
        val alarm = AlarmWithPressureUnderTheLowerThreshold()
        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }
}

class AlarmWithPressureUnderTheLowerThreshold: Alarm() {
    override fun popNextPressurePsiValue(): Double {
        return 0.0
    }
}
