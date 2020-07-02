package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Test
import org.junit.Assert.*

class TestAlarm {

    @Test
    fun `initialized alarm should be turned off`() {
        val alarm = Alarm()
        assertEquals(false, alarm.isAlarmOn)
    }
}
