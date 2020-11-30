package tddmicroexercises.textconvertor

import junit.framework.Assert.assertEquals
import org.junit.Test

class MultiPageTextRetrieverTest {

    @Test
    fun `returns the proper breaks in a multi page file`() {
        val pathName = this::class.java.getResource("/testSinglePage").path
        val textRetriever = MultiPageTextRetriever(pathName)
        assertEquals(arrayListOf(0, 73), textRetriever.breaks)
    }

    @Test
    fun `returns the proper breaks in a multi page file counting the lines`() {
        val pathName = this::class.java.getResource("/testSinglePage").path
        val textRetriever = MultiPageTextRetriever(pathName)
        assertEquals(arrayListOf(0, 3), textRetriever.listBreaks)
    }
}