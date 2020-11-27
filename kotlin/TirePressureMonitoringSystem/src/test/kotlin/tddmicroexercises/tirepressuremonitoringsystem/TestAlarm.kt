package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.Test
import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TestAlarm {

    @Mock
    private lateinit var pressureSensor: Sensor

    @Test
    fun foo() {
        val alarm = Alarm(pressureSensor)
        `when`(pressureSensor.popNextPressurePsiValue()).thenReturn(30.0)
        assertEquals(true, alarm.isAlarmOn)
    }
}
