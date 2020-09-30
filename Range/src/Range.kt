class Range (val biginOpen : Boolean, val a : Int, val b : Int, val endOpen : Boolean) {
    fun openCharacter(open : Boolean) : String {
        return if (open) {
            "("
        } else {
            "["
        }
    }
    fun closeCharacter(open : Boolean) : String {
        return if (open) {
            ")"
        } else {
            "]"
        }
    }
    fun lessThan (open : Boolean, smaller : Int, bigger : Int): Boolean {
        if (open)   return smaller < bigger
                    return smaller <= bigger
    }

    override fun toString(): String =
        "${openCharacter(this.biginOpen)}$a, $b${closeCharacter(this.endOpen)}"

    fun contains(isInRange : Int) =
        lessThan(this.biginOpen, this.a, isInRange) && lessThan(this.endOpen, isInRange, this.b)

    fun values(){
        var output = ""
        output += "["
        for (i in 1..this.size()){
            output += (this.a + i).toString()
            if (i < this.b) output += ","
        }
        output += "]"
        println(output)
    }

    private fun size(): Int = (this.b - this.a) + oneIfTrue(this.contains(this.a)) + oneIfTrue(this.contains(this.b))

    private fun oneIfTrue(contains: Boolean): Int = if (contains) 1 else 0
}