package tddmicroexercises.textconvertor

import java.io.IOException

class HtmlTextConverter(val filename: String, private val textRetriever: TextRetriever = FileTextRetriever(filename)) {

    @Throws(IOException::class)
    fun convertToHtml(): String {
        return textRetriever.getLines()
            .fold("", { acc, string -> acc + "${StringEscapeUtils.escapeHtml(string)}<br />"})
    }
}
