package subtask2

class MiniMaxSum {

    fun getResult(input: IntArray): IntArray {
//        throw NotImplementedError("Not implemented")
        var min = Integer.MAX_VALUE
        var max = Integer.MIN_VALUE
        for (i in input.indices) {
            var sum = 0
            input.forEachIndexed { index, e ->
                if (i != index) {
                    sum += e
                }
            }

            when {
                sum > max -> max = sum
                sum < min -> min = sum
            }
        }

        return intArrayOf(min, max)
    }
}
