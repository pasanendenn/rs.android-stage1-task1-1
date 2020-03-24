package subtask5

import kotlin.math.max

class HighestPalindrome {

    companion object {
        private const val ERROR = "-1"
        private const val MAX_NUM_VALUE = '9'
    }

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {

        val mutableList = digitString.toMutableList()

        /*if ((n % 2) != 0) {
            throw IllegalArgumentException("n is not a even number")
            val middleNum = n.plus(1).div(2)
            mutableList.removeAt(middleNum)
        }*/

        var mK = k

        for (i in 0 until n.div(2)) {

            if (mK == 0) break

            val pair = mutableList[i].toString().toInt() to mutableList[mutableList.lastIndex.minus(i)].toString().toInt()

            if (pair.first != pair.second) {
                if (max(pair.first, pair.second) == MAX_NUM_VALUE.toString().toInt()) {
                    if (pair.first == MAX_NUM_VALUE.toString().toInt()) {
                        mutableList[mutableList.lastIndex.minus(i)] = MAX_NUM_VALUE
                        mK--
                    } else {
                        mutableList[i] = MAX_NUM_VALUE
                        mK--
                    }
                } else if (mK >= 2) {
                    mutableList[i] = MAX_NUM_VALUE
                    mutableList[mutableList.lastIndex.minus(i)] = MAX_NUM_VALUE
                    mK -= 2
                } else if (k == 1) {
                    mutableList[i] = max(pair.first, pair.second).toString()[0]
                    mutableList[mutableList.lastIndex.minus(i)] = max(pair.first, pair.second).toString()[0]
                    mK--
                } else {
                    return ERROR
                }
            }
        }


        return concatToString(mutableList)
    }

    private fun concatToString(list: List<Char>): String {
        var result = ""
        list.forEach {
            result += it
        }
        return result
    }
}
