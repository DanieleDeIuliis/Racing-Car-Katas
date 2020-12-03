package tddmicroexercises.telemetrysystem

abstract class TelemetryClient {
    var onlineStatus: Boolean = false
        internal set
    abstract fun connectWith(telemetryServerConnectionString: String?, maxRetry: Int = 3): Boolean
    abstract fun disconnect()
    abstract fun send(message: String?)
    abstract fun receive(): String
    abstract fun retrieveDiagnosticMessage(): String

    companion object {
        val DIAGNOSTIC_MESSAGE = "AT#UD"
    }
}