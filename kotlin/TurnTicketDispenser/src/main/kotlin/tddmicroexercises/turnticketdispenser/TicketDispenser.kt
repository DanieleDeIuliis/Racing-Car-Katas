package tddmicroexercises.turnticketdispenser

class TicketDispenser(private val turnSequence: TurnSequence) {
    constructor() : this(StaticTurnSequence())

    val turnTicket: TurnTicket
        get() {
            return TurnTicket(turnSequence.next())
        }
}
