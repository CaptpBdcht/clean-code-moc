open class Entity (val name: String, var health: Int = 100) {

    fun alive() = this.health > 0


}