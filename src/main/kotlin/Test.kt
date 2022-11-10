/**
 * List of fucntions to test my leetcode submissions
 */


class Test {
    companion object {
        val root = "aa"
    }

    fun test(s: String) {
        val a = s.toCharArray()
    }
}


class Solution {

    fun romanToInt(s: String): Int {
        var total = 0
        var lastSymbol = ' '
        val ca = s.toCharArray()
        ca.forEach {
            total += getSymbolValue(it, lastSymbol)
            lastSymbol = it
        }
        return total
    }

    private fun getSymbolValue(symbol: Char, prevSymbol: Char): Int {
        println(symbol)
        println(prevSymbol)
        val intValue = when (symbol) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }

        if (prevSymbol == 'I' && listOf('V', 'X').contains(symbol)) {
            return intValue - 1
        }
        if (prevSymbol == 'X' && listOf('L', 'C').contains(symbol)) {
            return intValue - 10
        }
        if (prevSymbol == 'C' && listOf('D', 'M').contains(symbol)) {
            return intValue - 100
        }
        println(intValue)
        return intValue
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1..nums.lastIndex) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf(0, 0)
    }

    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        s.forEachIndexed { index, c ->
            for (j in index + 1..s.lastIndex) {
                if (c != s[j]) {
                    maxLength += 1
                } else {
                    maxLength = 0
                }
            }

        }
        return maxLength
    }


    fun containsDuplicate(nums: IntArray): Grouping<Int, Int> {
        val out =  nums.toList().groupingBy { it }
        return  out
    }
}

    fun main() {
//    println(Test.root)
        val solution = Solution()
//    Solution().romanToInt("MCMXCIV")
//    Solution().twoSum(nums = intArrayOf(2,5,5,11), target = 10).forEach {
//        println(it)
//    }
        println(solution.lengthOfLongestSubstring("abcabcbb"))
        println(solution.containsDuplicate( intArrayOf(1,1,1,3,3,4,3,2,4,2)) .toString())
    }
