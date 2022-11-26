package multiThread

// can implement runnable interface or extend thread class
class MyMultiThread(private val threadName: String) : Runnable {

    override fun run() {
        for (i in 0..5){
            println("$threadName::: $i")
            Thread.sleep(1000)
        }
    }

}


fun main(){
    //creating 3 threads
    for (i in 0..2){
        val runnableThreadObj = MyMultiThread(i.toString())
        val threadObj = Thread(runnableThreadObj)
        threadObj.start()
    }
}