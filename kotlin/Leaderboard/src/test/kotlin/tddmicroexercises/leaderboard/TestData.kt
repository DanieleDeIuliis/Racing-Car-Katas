package tddmicroexercises.leaderboard

object TestData {

    var humanDriver1: HumanDriver
    var humanDriver2: HumanDriver
    var humanDriver3: HumanDriver
    var driver4: SelfDrivingCar

    var race1: Race
    var race2: Race
    var race3: Race
    var race4: Race
    var race5: Race
    var race6: Race

    var sampleLeaderboard1: Leaderboard
    var sampleLeaderboard2: Leaderboard

    init {
        humanDriver1 = HumanDriver("Nico Rosberg", "DE")
        humanDriver2 = HumanDriver("Lewis Hamilton", "UK")
        humanDriver3 = HumanDriver("Sebastian Vettel", "DE")
        driver4 = SelfDrivingCar("1.2", "Acme")

        race1 = Race("Australian Grand Prix", humanDriver1, humanDriver2, humanDriver3)
        race2 = Race("Malaysian Grand Prix", humanDriver3, humanDriver2, humanDriver1)
        race3 = Race("Chinese Grand Prix", humanDriver2, humanDriver1, humanDriver3)
        race4 = Race("Fictional Grand Prix 1", humanDriver1, humanDriver2, driver4)
        race5 = Race("Fictional Grand Prix 2", driver4, humanDriver2, humanDriver1)
        driver4.algorithmVersion = "1.3"
        race6 = Race("Fictional Grand Prix 3", humanDriver2, humanDriver1, driver4)

        sampleLeaderboard1 = Leaderboard(race1, race2, race3)
        sampleLeaderboard2 = Leaderboard(race4, race5, race6)
    }
}
