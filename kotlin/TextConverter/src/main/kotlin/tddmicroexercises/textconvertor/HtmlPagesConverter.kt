package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList

class HtmlPagesConverter @Throws(IOException::class)
constructor(val filename: String, private val textRetriever: MultiPageTextRetriever = MultiPageTextRetriever(filename)) {


    @Throws(IOException::class)
    fun getHtmlPage(page: Int): String {
        val lines = textRetriever.getLines()
        val lineToStart = textRetriever.breaks[page]
        val htmlPage = StringBuffer()
        for(index in lineToStart until lines.size){
            if (lines.get(index).contains("PAGE_BREAK")) {
                break
            }
            htmlPage.append(StringEscapeUtils.escapeHtml(lines.get(index)))
            htmlPage.append("<br />")

        }
        return htmlPage.toString()
    }

}
