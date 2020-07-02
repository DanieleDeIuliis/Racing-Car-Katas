package tddmicroexercises.tirepressuremonitoringsystem

interface ISensor {
    fun popNextPressurePsiValue(): Double
}