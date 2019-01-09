fun main(args: Array<String>) {
    val player1 = Professional1()
    player1.play(player1.musicalInstrument)
    println(player1.instrumentType)
}

abstract class PlayMusic1 {
    val musicalInstrument: String = "piano"
    val instrumentType: Int
        get() = 1
    abstract fun play(musicalInstrument: String)
    fun sing() {}
}

class Professional1 : PlayMusic1() {
    override fun play(musicalInstrument: String) {
        println("professional play $musicalInstrument")
    }
}
