package tddmicroexercises.textconvertor

import org.junit.Test
import java.io.IOException

import org.junit.Assert.*

class HtmlPagesConverterTest {
    @Test
    @Throws(IOException::class)
    fun `return a single page`() {
        val pathName = this::class.java.getResource("/testSinglePage").path
        val converter = HtmlPagesConverter(pathName)
        assertEquals("Ciao sono un file di test.<br />Vediamo se funziona il multilinea.<br />", converter.getHtmlPage(0))
    }

    @Test
    @Throws(IOException::class)
    fun `return the second page`() {
        val pathName = this::class.java.getResource("/testMultiPage").path
        val converter = HtmlPagesConverter(pathName)
        assertEquals("Vediamo se funziona il multilinea.<br />", converter.getHtmlPage(1))
    }
}
