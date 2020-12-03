package tddmicroexercises.leaderboard

import org.junit.Test

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

import tddmicroexercises.leaderboard.TestData.humanDriver1
import tddmicroexercises.leaderboard.TestData.humanDriver2
import tddmicroexercises.leaderboard.TestData.humanDriver3
import tddmicroexercises.leaderboard.TestData.driver4

class LeaderboardTest {

    @Test
    fun itShouldSumThePoints() {
        // setup

        // act
        val results = TestData.sampleLeaderboard1.driverResults()

        // verify
        assertTrue("results $results", results.containsKey("Lewis Hamilton"))
        assertEquals((18 + 18 + 25).toLong(), (results.get("Lewis Hamilton") as Int).toLong())
    }

    @Test
    fun isShouldFindTheWinner() {
        // setup

        // act
        val result = TestData.sampleLeaderboard1.driverRankings()

        // verify
        assertEquals("Lewis Hamilton", result.get(0))
    }

    @Test
    fun itShouldKeepAllDriversWhenSamePoints() {
        // setup
        // bug, drops drivers with same points
        val winDriver1 = Race("Australian Grand Prix", humanDriver1, humanDriver2, humanDriver3)
        val winDriver2 = Race("Malaysian Grand Prix", humanDriver2, humanDriver1, humanDriver3)
        val exEquoLeaderBoard = Leaderboard(winDriver1, winDriver2)

        // act
        val rankings = exEquoLeaderBoard.driverRankings()

        // verify
        assertEquals(arrayListOf(humanDriver1.name, humanDriver2.name, humanDriver3.name), rankings)
        // note: the order of driver1 and driver2 is JDK/platform dependent
    }

    @Test
    fun `when only one race the self driving car wins`() {
        val winDriver1 = Race("Australian Grand Prix", driver4, humanDriver2, humanDriver3)
        val leaderbord = Leaderboard(winDriver1)
        val rankings = leaderbord.driverRankings()
        assertEquals(driver4.name, rankings.first())
    }
}
