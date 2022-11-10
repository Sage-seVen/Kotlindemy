package stack

class StackImpl<T: Any>: Stack<T> {

    private var storage = arrayListOf<T>()

    override val count: Int
        get() = storage.size

    override fun pop(): T? {
        return storage.removeLastOrNull()
    }

    override fun push(element: T) {
        storage.add(element)
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

}

fun String.isValidParenthesis(): Boolean {
    val stackObj = StackImpl<Char>()

    for (char in this){
        when(char){
            '(' -> stackObj.push(char)  //only pushing opening parens
            ')' -> {
                if (stackObj.isEmpty){
                    return false
                } else{
                    stackObj.pop() // for every closing parens , we pop one opening parens, till the loop finishes
                }
            }
        }
    }

    return stackObj.isEmpty //at the end, if the stack is empty, means pairs were even
}