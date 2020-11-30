package tddmicroexercises.textconvertor

class TextRetrieverMock(private val textToTest: String): TextRetriever("dummy") {
    override fun getLines(): List<String> {
        return textToTest.split("\n")
    }
}