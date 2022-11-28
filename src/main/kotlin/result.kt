import java.io.*
import java.util.stream.Collectors
import java.util.stream.IntStream

internal object Result {
    /*
     * Complete the 'maximumLearning' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY iv
     *  2. INTEGER_ARRAY articles
     *  3. INTEGER p
     */
    fun maximumLearning(iv: List<Int>, articles: List<Int>, p: Int): Int {
        // Write your code here
        val size = articles.size
        val artc = IntArray(size)
        val ivs = IntArray(size)
        for (i in 0 until size) {
            artc[i] = articles[i] * 2
            ivs[i] = iv[i]
        }
        return knapSack(ivs, artc, p, size)
    }

    fun knapSack(`val`: IntArray, wt: IntArray, W: Int, n: Int): Int {
        val mat = Array(n + 1) { IntArray(W + 1) }
        for (i in 1 until n + 1) {
            for (j in 1 until W + 1) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0
                } else if (wt[i - j] <= j) {
                    mat[i][j] = Math.max(`val`[i - 1] + mat[i - 1][j - wt[i - 1]], mat[i - 1][j])
                } else {
                    mat[i][j] = mat[i - 1][j]
                }
            }
        }
        return mat[n][W]
    }
}

////object Solution {
//    @Throws(IOException::class)
//    @JvmStatic
//    fun main(args: Array<String>) {
//        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
//        val bufferedWriter = BufferedWriter(FileWriter(System.getenv("OUTPUT_PATH")))
//        val ivCount = bufferedReader.readLine().trim { it <= ' ' }.toInt()
//        val iv = IntStream.range(0, ivCount).mapToObj { i: Int ->
//            try {
//                return@mapToObj bufferedReader.readLine().replace("\\s+$".toRegex(), "")
//            } catch (ex: IOException) {
//                throw RuntimeException(ex)
//            }
//        }
//            .map { obj: String -> obj.trim { it <= ' ' } }
//            .map { s: String -> s.toInt() }
//            .collect(Collectors.toList())
//        val articlesCount = bufferedReader.readLine().trim { it <= ' ' }.toInt()
//        val articles = IntStream.range(0, articlesCount).mapToObj { i: Int ->
//            try {
//                return@mapToObj bufferedReader.readLine().replace("\\s+$".toRegex(), "")
//            } catch (ex: IOException) {
//                throw RuntimeException(ex)
//            }
//        }
//            .map { obj: String -> obj.trim { it <= ' ' } }
//            .map { s: String -> s.toInt() }
//            .collect(Collectors.toList())
//        val p = bufferedReader.readLine().trim { it <= ' ' }.toInt()
//        val result = Result.maximumLearning(iv, articles, p)
//        bufferedWriter.write(result.toString())
//        bufferedWriter.newLine()
//        bufferedReader.close()
//        bufferedWriter.close()
//    }
//}