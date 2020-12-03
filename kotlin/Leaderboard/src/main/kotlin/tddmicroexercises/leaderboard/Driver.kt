package tddmicroexercises.leaderboard

abstract class Driver(open val name: String, val country: String) {
    override fun hashCode(): Int {
        return name.hashCode() * 31 + country.hashCode()
    }

    override fun equals(any: Any?): Boolean {
        if (this === any) {
            return true
        }
        if (any == null || any !is HumanDriver) {
            return false
        }
        val other = any as HumanDriver?
        return this.name == other!!.name && this.country == other.country
    }
}