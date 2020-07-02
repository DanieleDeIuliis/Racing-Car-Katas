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
        val alarm = Alarm(sensor = ProgrammableSensor(21.1))
        alarm.check()
        assertEquals(true, alarm.isAlarmOn)
    }

    @Test
    fun `one check should set alarm to on with low pressure`() {
        val alarm = Alarm(sensor = ProgrammableSensor(0.0))
        alarm.check()
        assertEquals(true, alarm.isAlarmOn)
    }

    @Test
    fun `alarm is off if the pressure is within specification`() {
        val alarm = Alarm(sensor = ProgrammableSensor(20.0))
        alarm.check()
        assertEquals(false, alarm.isAlarmOn)
    }

    class ProgrammableSensor(private val pressure: Double) : Sensor {
        override fun popNextPressurePsiValue(): Double = pressure
    }
}
