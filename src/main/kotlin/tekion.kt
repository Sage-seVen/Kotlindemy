class Tekion {
    fun sortArray(elements: List<Int>): ArrayList<Int> {

        var replaced: List<Any> = elements.map {
            if (it > 0){
                  it.toString()
            } else{
                it
            }
        }

        println(replaced)


        val positiveNumbers = elements.filter { it > 0 }.sortedDescending().reversed()
        println(positiveNumbers)



        var ff2 = arrayListOf<Int>()
        var count = positiveNumbers.indices

        var counter = 0
//        for (element in positiveNumbers){
            replaced.map {
                if (it is String){
                    ff2.add(positiveNumbers.get(counter))
                    counter++
                } else{
                    ff2.add(it as Int)
                }

            }
//        }


        return ff2
    }

}


fun main(){
    val obj = Tekion()

    val abc = (obj.sortArray( elements = listOf(-1, 3, 1, 4, -11, -12, 21, 11, 5, -2)))

    println(abc)
}

/*
Given an array of numbers, sort such that all the negative numbers position is preserved in output
in: [-1, 3, 1, 4, -11, -12, 21, 11, 5, -2]
out: [-1, 1, 3, 4, -11, -12, 5, 11, 21, -2]
*/





