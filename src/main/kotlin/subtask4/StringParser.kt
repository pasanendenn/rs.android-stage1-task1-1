package subtask4

class StringParser {

    private val squareBraces = '[' to ']'
    private val angleBraces = '<' to '>'
    private val roundBraces = '(' to ')'

    private val ignoreIndexes = arrayListOf<Int>()

    fun getResult(inputString: String): Array<String> {

        val wordsInBraces = arrayListOf<String>()

        for (i in inputString.indices) {
            val c = inputString[i]

            if (ignoreIndexes.contains(i)) continue

            when (c) {
                squareBraces.first -> {
                    val s = findCloseBrace(inputString.substring(i.plus(1)), squareBraces, i)
                    ignoreIndexes.add(i)
                    wordsInBraces.add(s)
                }
                angleBraces.first -> {
                    val s = findCloseBrace(inputString.substring(i.plus(1)), angleBraces, i)
                    ignoreIndexes.add(i)
                    wordsInBraces.add(s)
                }
                roundBraces.first -> {
                    val s = findCloseBrace(inputString.substring(i.plus(1)), roundBraces, i)
                    ignoreIndexes.add(i)
                    wordsInBraces.add(s)
                }
            }
        }
        return wordsInBraces.toTypedArray()
    }

    private fun findCloseBrace(
        substring: String,
        bracesPair: Pair<Char, Char>,
        lengthBefore: Int
    ): String {
        var counter = 0
        var result = ""

        for (i in substring.indices) {
            val c = substring[i]

            if (ignoreIndexes.contains(i)) continue

            when (c) {
                bracesPair.first -> counter++
                bracesPair.second -> {
                    if (counter == 0) {
                        result = substring.substring(0, i)
                        ignoreIndexes.add(i.plus(lengthBefore))
                    } else counter--
                }
            }
            if (result.isNotEmpty()) break
        }

        if (result.isEmpty()) throw IllegalArgumentException("inputString does not contain close brace")

        return result
    }
}
