open class Entity (open val name: String, open var health: Int = 100) {

    fun isAlive() : Boolean = this.health > 0
    override fun toString() : String = "${this.name} [health:${this.health}/100]"
}