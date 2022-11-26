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

fun binarySearchIterative(input: IntArray, eleToSearch: Int) : Int{
    var low = 0
    var high = input.size-1
    var mid:Int
    while(low <= high) {
        mid = low + ((high - low) / 2)
        when {
            eleToSearch >input[mid]   -> low = mid+1    // element is greater than middle element of array, so it will be in right half of array
            eleToSearch == input[mid] -> return mid // found the element
            eleToSearch < input[mid]  -> high = mid-1   //element is less than middle element of array, so it will be in left half of the array.
        }
    }
    return -1
}

fun main(){
    val array = intArrayOf(1, 4, 7, 8, 9, 11)
    println( binarySearch(array, 11, 0, array.size-1) )
}