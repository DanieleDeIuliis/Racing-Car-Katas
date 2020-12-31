package tddmicroexercises.leaderboard

import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Test
import tddmicroexercises.leaderboard.TestData.race1

class RaceTest {

    @Test
    fun isShouldCalculateDriverPoints() {
        // setup

        // act

        // verify
        Assert.assertEquals(25, TestData.race1.getPoints(TestData.humanDriver1))
        Assert.assertEquals(18, TestData.race1.getPoints(TestData.humanDriver2))
        Assert.assertEquals(15, TestData.race1.getPoints(TestData.humanDriver3))
    }

    @Test
    fun name() {
        val resultsWithPoints: Map<String, Int> = race1.getNameToPointsResults()

        assertEquals(25, resultsWithPoints["Nico Rosberg"])
        assertEquals(18, resultsWithPoints["Lewis Hamilton"])
        assertEquals(15, resultsWithPoints["Sebastian Vettel"])
    }
}
