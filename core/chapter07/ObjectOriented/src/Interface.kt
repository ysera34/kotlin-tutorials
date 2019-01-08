fun main(args: Array<String>) {
    val player1 = Professional("piano")
    player1.play(player1.musicalInstrument)
    println(player1.instrumentType)

    val player2 = Amateur()
    player2.play(player2.musicalInstrument)
    println(player2.instrumentType)
}

interface PlayMusic {
    val musicalInstrument: String
    val instrumentType: Int
        get() = 1
    fun play(musicalInstrument: String)
}

class Professional(override val musicalInstrument: String) : PlayMusic {
    override fun play(musicalInstrument: String) {
        println("professional play $musicalInstrument")
    }
}

class Amateur : PlayMusic {
    override var musicalInstrument: String = "guitar"
    override fun play(musicalInstrument: String) {
        println("Amateur play $musicalInstrument")
    }
}
