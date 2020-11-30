package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList

class HtmlPagesConverter @Throws(IOException::class)
constructor(val filename: String, private val textRetriever: MultiPageTextRetriever = MultiPageTextRetriever(filename)) {


    @Throws(IOException::class)
    fun getHtmlPage(page: Int): String {
        val reader = BufferedReader(FileReader(this.filename))
        reader.skip(textRetriever.breaks[page].toLong())
        val htmlPage = StringBuffer()
        var line: String? = reader.readLine()
        while (line != null) {
            if (line.contains("PAGE_BREAK")) {
                break
            }
            htmlPage.append(StringEscapeUtils.escapeHtml(line))
            htmlPage.append("<br />")

            line = reader.readLine()
        }
        reader.close()
        return htmlPage.toString()
    }

}
