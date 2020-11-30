package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader
import kotlin.streams.toList

open class TextRetriever(private val filename: String) {

    open fun getLines(): List<String> {
        return BufferedReader(FileReader(filename)).lines().toList()
    }
}