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
            race.results.forEach { driver ->
                val driverName = race.getDriverName(driver)
                val points = race.getPoints(driver)
                results[driverName!!] = results.getOrDefault(driverName,0).plus(points)
            }
        }
        return results
    }

    fun driverRankings(): List<String> {
        val results = driverResults()
        return driverResults().keys.sortedByDescending { results[it] }
    }

}
