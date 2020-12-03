package tddmicroexercises.telemetrysystem

class TelemetryStub(private val diagnosticMessage: String, private val isConnected: Boolean): TelemetryClient(){
    override fun connectWith(telemetryServerConnectionString: String?, maxRetry: Int): Boolean {
        return isConnected
    }

    override fun disconnect() {

    }

    override fun send(message: String?) {
        TODO("Not yet implemented")
    }

    override fun receive(): String {
        TODO("Not yet implemented")
    }

    override fun retrieveDiagnosticMessage(): String {
        return diagnosticMessage
    }
}