package tddmicroexercises.leaderboard

class Race(private val name: String, vararg drivers: Driver) {
    private val POINTS = arrayOf(25, 18, 15)
    private val results: List<Driver>

    init {
        this.results = arrayListOf(*drivers)
    }

    private fun position(driver: Driver): Int {
        return this.results.indexOf(driver)
    }


    fun getPoints(driver: Driver): Int {
        val position = position(driver)
        return if(position <= 3) POINTS[position] else 0
    }

    override fun toString(): String {
        return name
    }

    fun getNameToPointsResults(): Map<String, Int> {
        val resultsWithPoints = mutableMapOf<String, Int>()
        results.forEach { resultsWithPoints[it.name] = getPoints(it)}
        return resultsWithPoints
    }
}
