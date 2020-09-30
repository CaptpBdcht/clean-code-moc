fun main (args : Array<String>){
    println("Range open")
    val rangeOpen_1_3 = Range(true, 1, 3, true)
    println(rangeOpen_1_3)
    println("contains 1? : " + rangeOpen_1_3.contains(1))
    println("contains 2? : " + rangeOpen_1_3.contains(2))
    println("contains 3? : " + rangeOpen_1_3.contains(3))

    println("\nRange closed")
    val rangeClosed_1_3 = Range(false, 1, 3, false)
    println("contains 1? : " + rangeClosed_1_3.contains(1))
    println("contains 2? : " + rangeClosed_1_3.contains(2))
    println("contains 3? : " + rangeOpen_1_3.contains(3))

    println("size : " + rangeClosed_1_3.size())
    println("values : " + rangeClosed_1_3.values())


}