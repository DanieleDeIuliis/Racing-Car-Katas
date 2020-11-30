package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader

class MultiPageTextRetriever(private val filename: String): TextRetriever(filename) {
    val breaks = mutableListOf<Int>()
    val listBreaks = mutableListOf<Int>()
    init {
        this.breaks.add(0)
        this.listBreaks.add(0)
        val reader = BufferedReader(FileReader(this.filename))
        var cumulativeCharCount = 0
        var line: String? = reader.readLine()
        var lineCount = 1
        while (line != null) {
            cumulativeCharCount += line.length + 1 // add one for the newline
            if (line.contains("PAGE_BREAK")) {
                val page_break_position = cumulativeCharCount
                breaks.add(page_break_position)
                listBreaks.add(lineCount)
            }
            line = reader.readLine()
            lineCount++
        }
        reader.close()
    }
}