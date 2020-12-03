package tddmicroexercises.telemetrysystem

class TelemetryDiagnosticControls(private val telemetryClient: TelemetryClient) {
    constructor() : this(GeneralTelemetryClient())
    private val DiagnosticChannelConnectionString = "*111#"

    var diagnosticInfo = ""
    private set

    @Throws(Exception::class)
    fun checkTransmission() {

        telemetryClient.disconnect()

        if(!telemetryClient.connectWith(DiagnosticChannelConnectionString)){
            throw Exception()
        }

        diagnosticInfo = telemetryClient.retrieveDiagnosticMessage()
    }
}
