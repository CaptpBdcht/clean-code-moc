// To RUN
// kotlinc range.kt -include-runtime -d range.jar
// java -jar range.jar

class Range(_isBoundaryAOpen: Boolean,  _boundaryA: Int, _boundaryB: Int, _isBoundaryBOpen: Boolean) {
    val boundaryA: Int = _boundaryA
    val boundaryB: Int = _boundaryB
    val isBoundaryAOpen: Boolean = _isBoundaryAOpen
    val isBoundaryBOpen: Boolean = _isBoundaryBOpen

    fun contains(value: Int): Boolean{
        val boundaryATemp: Int = if (isBoundaryAOpen) (boundaryA + 1) else boundaryA
        val boundaryBTemp: Int = if (isBoundaryBOpen) (boundaryB - 1) else boundaryB

        for (i in boundaryATemp..boundaryBTemp ) {
            if (value == i) {
                return true
            }
        }

        return false
    }

    fun contains(interval: Range): Boolean {
        if (boundaryA > interval.boundaryA || boundaryB < interval.boundaryB)
            return false

        if ((boundaryB < interval.boundaryA) || (boundaryA > interval.boundaryB))
            return false
            
        return true
    }

    fun size(): Int {
        var rangeSize = 0
        val boundaryATemp: Int = if (isBoundaryAOpen) (boundaryA + 1) else boundaryA
        val boundaryBTemp: Int = if (isBoundaryBOpen) (boundaryB - 1) else boundaryB

        for (i in boundaryATemp..boundaryBTemp ) {
            rangeSize++
        }

        return rangeSize
    }

    fun values(): List<Int> {
        val valueList = mutableListOf<Int>()
        val boundaryATemp: Int = if (isBoundaryAOpen) (boundaryA + 1) else boundaryA
        val boundaryBTemp: Int = if (isBoundaryBOpen) (boundaryB - 1) else boundaryB

        for (i in boundaryATemp..boundaryBTemp ) {
            valueList.add(i)
        }

        return valueList
    }

    fun endPoints(): String {
        val boundaryATemp: Int = if (isBoundaryAOpen) (boundaryA + 1) else boundaryA
        val boundaryBTemp: Int = if (isBoundaryBOpen) (boundaryB - 1) else boundaryB

        return  "[" + "$boundaryATemp" + "," + "$boundaryBTemp" + "]"
    }
}

fun main() {
    val testRange = Range(true, 2, 4, true)
    val secondTestRange = Range(false, 5, 6, false)

    println(testRange.contains(4))

    println(testRange.size())

    println(testRange.values())
    
    println(testRange.endPoints())

    println(testRange.contains(secondTestRange))
}
