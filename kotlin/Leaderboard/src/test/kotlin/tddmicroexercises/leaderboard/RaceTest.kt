package tddmicroexercises.leaderboard

import org.junit.Assert
import org.junit.Test

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

}
