package tddmicroexercises.leaderboard

data class SelfDrivingCar(var algorithmVersion: String, val company: String) : Driver{
        override val name = "Self Driving Car - $company ($algorithmVersion)"
}
