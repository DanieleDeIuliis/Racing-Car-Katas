package tddmicroexercises.textconvertor

import org.junit.Assert.*
import org.junit.Test

class HtmlTextConverterTest {
    @Test
    fun `return the lines with html new line value at the end of each line `() {
        val converter = HtmlTextConverter("dummy", TextRetrieverMock("Ciao sono un file di test.\n" +
                "Vediamo se funziona il multilinea."))
        assertEquals("Ciao sono un file di test.<br />Vediamo se funziona il multilinea.<br />", converter.convertToHtml())
    }

    @Test
    fun `return a line with the html new line at the end and  & symbol converted `() {
        val pathName = this::class.java.getResource("/test&").path
        val converter = HtmlTextConverter(pathName)
        assertEquals("Vediamo se funziona &amp;<br />", converter.convertToHtml())
    }

    @Test
    fun `return a line with the html new line at the end and  minus symbol converted `() {
        val pathName = this::class.java.getResource("/testMinus").path
        val converter = HtmlTextConverter(pathName)
        assertEquals("Vediamo se funziona &lt;<br />", converter.convertToHtml())
    }

    @Test
    fun `return a line with the html new line at the end and  greater symbol converted `() {
        val pathName = this::class.java.getResource("/testGreater").path
        val converter = HtmlTextConverter(pathName)
        assertEquals("Vediamo se funziona &gt;<br />", converter.convertToHtml())
    }

    @Test
    fun `return a line with the html new line at the end and ' symbol converted `() {
        val pathName = this::class.java.getResource("/testSingleQuot").path
        val converter = HtmlTextConverter(pathName)
        assertEquals("Vediamo se funziona &quot;<br />", converter.convertToHtml())
    }

    @Test
    fun `return a line with the html new line at the end and " symbol converted `() {
        val pathName = this::class.java.getResource("/testDoubleQuot").path
        val converter = HtmlTextConverter(pathName)
        assertEquals("Vediamo se funziona &quot;<br />", converter.convertToHtml())
    }
}
