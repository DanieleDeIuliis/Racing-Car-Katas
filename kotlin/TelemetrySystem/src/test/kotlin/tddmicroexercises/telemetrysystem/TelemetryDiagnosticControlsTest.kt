package tddmicroexercises.telemetrysystem

import junit.framework.Assert.assertEquals
import org.junit.Test

class TelemetryDiagnosticControlsTest {

    @Test
    fun `checkTransmission should send a diagnostic message and receive a status message response`() {
        val diagnosticMessage = "I'm a beautiful diagnostic message"
        val telemetryClientStub = TelemetryStub(diagnosticMessage, true)
        val telemetryDiagnosticControls = TelemetryDiagnosticControls(telemetryClientStub)
        telemetryDiagnosticControls.checkTransmission()
        assertEquals("I'm a beautiful diagnostic message",telemetryDiagnosticControls.diagnosticInfo)
    }

    @Test(expected = Exception::class)
    fun `connection failed`() {
        val telemetryClientStub = TelemetryStub("diagnosticMessage", false)
        val telemetryDiagnosticControls = TelemetryDiagnosticControls(telemetryClientStub)
        telemetryDiagnosticControls.checkTransmission()
    }
}
