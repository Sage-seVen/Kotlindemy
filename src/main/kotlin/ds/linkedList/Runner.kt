package ds.linkedList

fun main(){
    val list = Node(1, Node(2, Node(3, Node(4, Node(5)))))

    println(list)
    list.printInReverse()
}