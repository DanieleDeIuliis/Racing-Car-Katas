package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import kotlin.streams.toList

class HtmlTextConverter(private val filename: String, private val textRetriever: TextRetriever = TextRetriever(filename)) {

    fun convertToHtml(): String {
        val linesToConvert = textRetriever.getLines()
        var html = ""
        linesToConvert.forEach { html += "${StringEscapeUtils.escapeHtml(it)}<br />"}
        return html

    }
}
