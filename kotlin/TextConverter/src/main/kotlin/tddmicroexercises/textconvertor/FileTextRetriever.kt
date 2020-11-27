package tddmicroexercises.textconvertor

import java.io.FileNotFoundException
import java.io.FileReader
import java.util.Collections.emptyList

class FileTextRetriever(private val filename: String): TextRetriever {
    override fun getLines(): List<String> {
        var fileReader: FileReader? = null
        try{
            fileReader = FileReader(filename)
        }catch (e: FileNotFoundException){
            return emptyList()
        }
        return fileReader.readLines()
    }
}