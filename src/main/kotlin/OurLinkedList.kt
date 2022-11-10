class OurLinkedList {

    private var first: Node? = null

    val lastNode: Node?
        get() {
            var currentNode = first
            while (currentNode?.next != null){
                currentNode = currentNode.next
            }
            return currentNode
        }

    val size: Int
        get() {
            var count = 0
            var currentNode = first
            while (currentNode != null){
                count ++
                currentNode = currentNode.next
            }
            return count
        }


    fun addToHead(data: String){
        val newNode = Node(data= data, next = first)
        first = newNode
    }


    fun addToTail(data: String){
        val newNode = Node(data = data, next = null)

        if (first == null){
            first = newNode
        } else {
            lastNode!!.next = newNode
        }
    }

    fun remove(index: Int){

        if(index == 0){
            first = first?.next
            return
        }

        val beforeNode = getNode(index-1)
        val afterNode = getNode(index+1)

        beforeNode.next = afterNode
    }

    fun getNode(index: Int): Node {
        var currentNode = first
        /*
        as first is already assigned, we have to run loop one time less, its better to use repeat,
        so for getting 2nd index, we run loop 2 (1 to 2) times, not 0 to 2
        */

        repeat(index){
            currentNode = currentNode?.next
        }
        return currentNode ?: throw NodeNotFoundException("Node")
    }

    fun getAll(){
        var currentNode = first
//        println("Node at 0 is ${currentNode?.data}")
        var index = 0
        while(currentNode != null){
            println("Node at $index is ${currentNode?.data}")
            currentNode = currentNode.next
            index++
        }
    }

}

class Node(val data: String, var next: Node?)

data class NodeNotFoundException(val name: String): IllegalArgumentException("$name not found")

fun main(){
    val list = OurLinkedList()

    list.addToTail("dat 1")
    list.addToTail("dat 2")
    list.addToTail("dat 3")
    list.addToTail("dat 4")
    list.addToTail("dat 5")
    list.addToTail("dat 6")
    list.addToTail("dat 22")
    list.addToTail("dat 24")

    println(list.getNode(0).data)
    println(list.getNode(1).data)

    list.getAll()

    println(list.lastNode?.data)
    println(list.size)

    list.addToHead("dat 0000")

    list.getAll()

    list.remove(7)
    list.getAll()
}