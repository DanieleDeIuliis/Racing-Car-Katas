package tddmicroexercises.leaderboard

import java.util.*

class Leaderboard(vararg races: Race) {

    private val races: List<Race>

    init {
        this.races = arrayListOf(*races)
    }

    fun driverResults(): Map<String, Int> {
        val results = HashMap<String, Int>()
        this.races.forEach { race ->
            race.getNameToPointsResults().forEach { (name, points) -> results[name] = results.getOrDefault(name, 0).plus(points)}
        }
        return results
    }

    fun driverRankings(): List<String> {
        val results = driverResults()
        return driverResults().keys.sortedByDescending { results[it] }
    }

}
