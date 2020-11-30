package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.lang.StringBuilder
import java.util.ArrayList

class HtmlPagesConverter @Throws(IOException::class)
constructor(val filename: String, private val textRetriever: MultiPageTextRetriever = MultiPageTextRetriever(filename)) {


    @Throws(IOException::class)
    fun getHtmlPage(page: Int): String {
        val lines = textRetriever.getLines()
        val stringBuilder = StringBuilder()
        for(index in textRetriever.listBreaks[page] until lines.size){
            if (lines[index].contains("PAGE_BREAK")) {
                break
            }
            stringBuilder.append(StringEscapeUtils.escapeHtml(lines[index]))
                .append("<br />")
        }
        return stringBuilder.toString()
    }

}
