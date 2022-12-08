package ds.tree

fun makeBikeTree(): TreeNode<String>{

    val tree = TreeNode("Bikes")

    val sportBikes = TreeNode("Sports")
    val nakedBikes = TreeNode("Naked")


    val parallelTwin = TreeNode("ParallelTwin")
    val v4 = TreeNode("V4")
    val inline4 = TreeNode("Inline4")

    val cruiser = TreeNode("Cruiser")
    val roadster = TreeNode("Roadster")
    val bobber = TreeNode("Bobber")


    tree.add(sportBikes)
    tree.add(nakedBikes)

    sportBikes.add(parallelTwin)
    sportBikes.add(v4)
    sportBikes.add(inline4)

    nakedBikes.add(cruiser)
    nakedBikes.add(roadster)
    nakedBikes.add(bobber)

    return tree
}

fun main(){
    val tree = makeBikeTree()

    //Depth-First
    tree.forEachDepthFirst { println(it.value) }

    println("*************************")

    //Bread-first
    tree.forEachLevelOrder { println(it.value) }

    tree.search("V4")

    println("*************************")
    tree.printEachLevel()
}