package tddmicroexercises.textconvertor

import org.junit.Assert.*
import org.junit.Test

class HtmlTextConverterIntegrationTest {
    @Test
    fun `test actual behaviour`() {
        val converter = HtmlTextConverter("src/test/resources/html_test")
        val converted = converter.convertToHtml()
        assertEquals(
            "Lorem ipsum<br />Nam non &amp; &lt;<br />Praesent<br />Fusce posuere<br />Suspendisse<br />5<br />",
            converted
        )
    }
}
