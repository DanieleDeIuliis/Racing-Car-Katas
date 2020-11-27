package tddmicroexercises.textconvertor

import org.junit.Test
import java.io.IOException

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HtmlPagesConverterTest {

    @Mock
    private lateinit var textRetriever: TextRetriever

    @Test
    @Throws(IOException::class)
    fun foo() {
        val converter = HtmlPagesConverter("foo")
        assertEquals("fixme", converter.filename)
    }

    @Test
    fun `returns the html version of a two lines message single page`() {
        val converter = HtmlPagesConverter("foo", textRetriever)
        Mockito.`when`(textRetriever.getLines()).thenReturn(listOf("randomText","greetings"))
        assertEquals("randomText<br />greetings<br />", converter.getHtmlPage(1))
    }

    @Test
    fun `returns the html version of a two lines message multi page`() {
        Mockito.`when`(textRetriever.getLines()).thenReturn(listOf("PAGE_BREAK","randomText","greetings"))
        val converter = HtmlPagesConverter("foo", textRetriever)
        assertEquals("randomText<br />greetings<br />", converter.getHtmlPage(2))
    }
}
