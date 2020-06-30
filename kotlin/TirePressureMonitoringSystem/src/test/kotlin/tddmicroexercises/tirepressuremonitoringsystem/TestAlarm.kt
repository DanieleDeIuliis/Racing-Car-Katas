package tddmicroexercises.tirepressuremonitoringsystem

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.*
import org.junit.Test

class TestAlarm {

    private val sensor = mockk<Sensor>()
    private val alarm = Alarm(sensor)

    @Test
    fun `initially the alarm is always off`() {
        val alarm = Alarm(SimulatedSensor())
        assertEquals(false, alarm.isAlarmOn)
    }

    @Test
    fun `raise the alarm when the pressure measured by the sensor is under the lower threshold`() {
        every { sensor.popNextPressurePsiValue() } returns 1.0

        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }

    @Test
    fun `raise the alarm when the pressure measured by the sensor is over the higher threshold`() {
        every { sensor.popNextPressurePsiValue() } returns 300.0

        alarm.check()
        assertTrue(alarm.isAlarmOn)
    }

    @Test
    fun `does not raise the alarm when the pressure measured by the sensor is within the acceptable range`() {
        every { sensor.popNextPressurePsiValue() } returns 20.0

        alarm.check()
        assertFalse(alarm.isAlarmOn)
    }
}
