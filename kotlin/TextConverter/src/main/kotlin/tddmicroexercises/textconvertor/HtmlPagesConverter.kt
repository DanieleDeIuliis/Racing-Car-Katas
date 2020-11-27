package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.ArrayList

class HtmlPagesConverter @Throws(IOException::class)
constructor(val filename: String, private val textRetriever: TextRetriever = FileTextRetriever(filename)) {
    private val breaks = ArrayList<Int>()

    init {
        this.breaks.add(0)
        val lines = textRetriever.getLines()
        lines.forEachIndexed{index, line -> if(line.contains("PAGE_BREAK")) this.breaks.add(index + 1)}
    }

    @Throws(IOException::class)
    fun getHtmlPage(page: Int): String {
        val htmlPage = StringBuffer()
        val lines = textRetriever.getLines()
        for(i in breaks[page - 1] until lines.size){
            htmlPage.append(StringEscapeUtils.escapeHtml(lines[i]))
            htmlPage.append("<br />")
        }
        return htmlPage.toString()
    }

}
