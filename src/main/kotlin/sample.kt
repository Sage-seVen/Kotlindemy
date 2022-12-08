//class sample {
//}
//
//
//fun main(){
//
//    var arr = mutableListOf<Int>(0, 1, 0, 1, 1, 0, 0, 1)
//
//
//
//    for(i in 0 until arr.size-1){
//        if (arr[i]< arr[i+1]){
//            val temp = arr[i]
//            arr[i] = arr[i+1]
//            arr[i+1] = temp
//        }
//    }
//
//    println(arr)
//}


import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*



/*
 * Complete the 'decryptPassword' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

fun decryptPassword(s: String): String {
    // Write your code here
    var inputList = s.toCharArray().toMutableList()
    var digitlist = arrayListOf<Int>()
    println(inputList.size)
    println(inputList.indices)
    for(i in inputList.indices){
        println(inputList[i])
        val current = inputList[i]
        // val next  = inputList.get(i+1)
        if(current.isDigit() && current != '0'){
            digitlist.add(current.toInt())
            inputList.removeAt(i)
        }
    }
    // println(inputList)
    return s
}

fun main(args: Array<String>) {
//    val s = readLine()!!

    val result = decryptPassword("51Pa*0Lp*0e11")

    println(result)
}
