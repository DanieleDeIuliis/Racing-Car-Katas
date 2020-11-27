package tddmicroexercises.textconvertor

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import java.io.BufferedReader
@RunWith(MockitoJUnitRunner::class)
class HtmlTextConverterTest {

    @Mock
    private lateinit var textRetriever: TextRetriever

    @Test
    fun foo() {
        val converter = HtmlTextConverter("foo", textRetriever)
        `when`(textRetriever.getLines()).thenReturn(listOf("randomText"))
        assertEquals("randomText<br />", converter.convertToHtml())
    }

    @Test
    fun `returns the html version of a two lines message`() {
        val converter = HtmlTextConverter("foo", textRetriever)
        `when`(textRetriever.getLines()).thenReturn(listOf("randomText","greetings"))
        assertEquals("randomText<br />greetings<br />", converter.convertToHtml())
    }
}
