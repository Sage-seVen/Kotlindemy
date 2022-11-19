package algos.search

fun binarySearch( input: IntArray, elementToSearch: Int, low: Int, high: Int): Int{
    while (high >= low){
        val mid = (low + high) / 2
        when {
            elementToSearch > input[mid] -> return binarySearch(input, elementToSearch, low = mid + 1, high = high)
            elementToSearch < input[mid] -> return binarySearch(input, elementToSearch, low = low, high = mid-1)
            elementToSearch == input[mid] -> return mid
        }
    }
    return -1
}

fun main(){
    val array = intArrayOf(1, 4, 7, 8, 9, 11)
    println( binarySearch(array, 11, 0, array.size-1) )
}