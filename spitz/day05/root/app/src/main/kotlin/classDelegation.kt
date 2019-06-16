fun classDelegationTest() {
    val sportsCar = SportsCar(Car("sport car"))
    println("sportsCar - ${sportsCar.move()}")
    println("sportsCar - ${sportsCar.stop()}")
    println("sportsCar - ${sportsCar.highSpeed()}")

    val fastCar = FastCar(Car("fast car"))
    println("fastCar - ${fastCar.move()}")
    println("fastCar - ${fastCar.stop()}")
    println("fastCar - ${fastCar.fastSpeed()}")

    val ultraCar = UltraCar(Car("taxi"))
    println("ultraCar - ${ultraCar.move()}")
    println("ultraCar - ${ultraCar.stop()}")
    println("ultraCar - ${ultraCar.ultraSpeed()}")

    ultraCar.car = Car("bus")
    println("ultraCar - ${ultraCar.move()}")
    println("ultraCar - ${ultraCar.stop()}")
    println("ultraCar - ${ultraCar.ultraSpeed()}")

    val extremeCar = ExtremeCar()
    println("extremeCar - ${extremeCar.move()}")
    println("extremeCar - ${extremeCar.stop()}")
    println("extremeCar - ${extremeCar.extremeSpeed()}")
}

interface Mobile {
    fun move(): String
    fun stop(): String
}

class Car(val name: String) : Mobile {
    override fun move() = "$name move"
    override fun stop() = "$name stop"
}

class SportsCar(val car: Mobile) : Mobile {
    override fun move() = car.move()
    override fun stop() = car.stop()
    fun highSpeed() = "high speed move"
}

class FastCar(car: Mobile) : Mobile by car {
    fun fastSpeed() = "fast speed move"
}

class UltraCar(var car: Mobile) : Mobile by car {
    fun ultraSpeed() = "ultra speed move"
}

class ExtremeCar : Mobile by object : Mobile {
    val name = "extreme"
    override fun move() = "$name move"
    override fun stop() = "$name stop"
} {
    fun extremeSpeed() = "extreme speed move"
}
