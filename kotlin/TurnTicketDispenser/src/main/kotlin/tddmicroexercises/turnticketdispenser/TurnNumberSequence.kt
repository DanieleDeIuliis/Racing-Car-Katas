package tddmicroexercises.turnticketdispenser

object TurnNumberSequence {
    private var turnNumber = 0

    val nextTurnNumber: Int
        get() = turnNumber++
}

interface TurnSequence {
    fun next(): Int
}

class StaticTurnSequence : TurnSequence {
    override fun next(): Int {
        return TurnNumberSequence.nextTurnNumber
    }
}

class IncrementalTurnSequence : TurnSequence {
    private var number = 0
    override fun next(): Int {
        return number++
    }

}