package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {

        val sadList = sadArray.toCollection(ArrayList())
        val deleteIndexes = arrayListOf<Int>()
        do {
            val deleteIndexesSizeBefore = deleteIndexes.size
            for (i in 1 until sadList.lastIndex) {
                val previous = sadList[i - 1]
                val next = sadList[i + 1]
                val sum = previous + next
                if (sum < sadList[i]) {
                    deleteIndexes.add(i)
                }
            }
            val deleteIndexesAfter = deleteIndexes.size
            deleteIndexes.reverse()
            deleteIndexes.forEach {
                sadList.removeAt(it)
            }
            deleteIndexes.clear()
        } while (deleteIndexesSizeBefore < deleteIndexesAfter)


        deleteIndexes.reverse()
        deleteIndexes.forEach {
            sadList.removeAt(it)
        }
        return sadList.toIntArray()
    }
}
