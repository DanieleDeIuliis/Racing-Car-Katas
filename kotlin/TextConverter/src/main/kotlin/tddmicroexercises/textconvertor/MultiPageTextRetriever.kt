package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader

class MultiPageTextRetriever(private val filename: String): TextRetriever(filename) {
    val listBreaks = mutableListOf<Int>()
    init {
        this.listBreaks.add(0)
        getLines().forEachIndexed{index, line ->  if(line.contains("PAGE_BREAK")) this.listBreaks.add(index + 1)}
    }
}