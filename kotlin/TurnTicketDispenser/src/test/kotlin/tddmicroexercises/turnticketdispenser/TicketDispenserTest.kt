package tddmicroexercises.turnticketdispenser

import org.junit.Assert.assertEquals
import org.junit.Test


class TicketDispenserTest {


    @Test
    fun `receive an increment sequence number from two ticketDispenser`() {
        val ticketDispenser = TicketDispenser()
        val anotherTicketDispenser = TicketDispenser()
        assertEquals(0, ticketDispenser.turnTicket.turnNumber)
        assertEquals(1, ticketDispenser.turnTicket.turnNumber)
        assertEquals(2, anotherTicketDispenser.turnTicket.turnNumber)
        assertEquals(3, ticketDispenser.turnTicket.turnNumber)
    }

    @Test
    fun `XX`() {
        val incrementalTurnSequence = IncrementalTurnSequence()
        val ticketDispenser = TicketDispenser(incrementalTurnSequence)
        val anotherTicketDispenser = TicketDispenser(incrementalTurnSequence)
        assertEquals(0, ticketDispenser.turnTicket.turnNumber)
        assertEquals(1, ticketDispenser.turnTicket.turnNumber)
        assertEquals(2, anotherTicketDispenser.turnTicket.turnNumber)
        assertEquals(3, ticketDispenser.turnTicket.turnNumber)
    }
}