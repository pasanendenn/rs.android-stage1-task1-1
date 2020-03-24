package subtask3

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {

        var annaBill = 0

        bill.forEachIndexed { index, e ->
            if (index != k)
                annaBill += e
        }
        annaBill = annaBill.div(2)

        return  if (b == annaBill) "Bon Appetit"
                else b.minus(annaBill).toString()
    }
}
