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

    
}