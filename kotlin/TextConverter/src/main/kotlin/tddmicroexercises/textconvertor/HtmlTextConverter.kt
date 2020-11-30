package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import kotlin.streams.toList

class HtmlTextConverter(private val filename: String) {

    @Throws(IOException::class)
    fun convertToHtml(): String {

        val linesToConvert = getLines()
        var html = ""
        linesToConvert.forEach { html += "${StringEscapeUtils.escapeHtml(it)}<br />"}
        return html

    }

    fun getLines(): List<String> {
        return BufferedReader(FileReader(filename)).lines().toList()

    }
}
