package ds.tree

import ds.queue.QueueImpl

typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(val value : T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>){
        children.add(child)
    }

    fun forEachDepthFirst(visit: Visitor<T>){
        visit(this)

        children.forEach{
            it.forEachDepthFirst { visit(it) }
        }
    }

    fun forEachLevelOrder(visit: Visitor<T>){
        visit(this)

        val queue = QueueImpl<TreeNode<T>>()
        children.forEach{
            queue.enqueue(it)
        }

        var node = queue.dequeue()
        while (node != null){
            visit(node)

            node.children.forEach {
                queue.enqueue(it)
            }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>?{
        var result : TreeNode<T>? = null

        forEachDepthFirst {
            if (it.value == value){
                result = it
                println("Value found $value")
            }
        }
        return result
    }

    fun printEachLevel(){
        var queue = QueueImpl<TreeNode<T>>()

        var nodesLeftInCurrentLevel = 0

        queue.enqueue(this)
        while (queue.isEmpty.not()){
            nodesLeftInCurrentLevel = queue.count

            while (nodesLeftInCurrentLevel > 0){
                val node = queue.dequeue()

                if (node!=null){
                    println("${node.value}")

                    node.children.forEach { queue.enqueue(it) }

                    nodesLeftInCurrentLevel--
                } else{
                    break
                }
            }

        }
    }

}