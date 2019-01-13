fun main(args: Array<String>) {
    val rectangle = Rectangle()
    val circle = Circle()
    Window(rectangle).drawFigure()
    Window(rectangle).fillFigure()
    Window(circle).drawFigure()
    Window(circle).fillFigure()

    val byRectangle = ByRectangle()
    val byCircle = ByCircle()
    ByWindow(byRectangle).draw()
    ByWindow(byRectangle).fill()
    ByWindow(byCircle).draw()
    ByWindow(byCircle).fill()
}

abstract class Figure {
    abstract fun draw()
    abstract fun fill()
}

class Rectangle : Figure() {
    override fun draw() {
        println("Draw Rectangle")
    }

    override fun fill() {
        println("Fill Rectangle")
    }
}

class Circle : Figure() {
    override fun draw() {
        println("Draw Circle")
    }

    override fun fill() {
        println("Fill Circle")
    }
}

class Window(val figure: Figure) {
    fun drawFigure() {
        figure.draw()
    }
    fun fillFigure() {
        figure.fill()
    }
}

// kotlin by delegation
interface ByFigure {
    fun draw()
    fun fill()
}

class ByRectangle : ByFigure {
    override fun draw() {
        println("Draw By Rectangle")
    }

    override fun fill() {
        println("Fill By Rectangle")
    }
}

class ByCircle : ByFigure {
    override fun draw() {
        println("Draw By Circle")
    }

    override fun fill() {
        println("Fill By Circle")
    }
}

//class ByWindow(val figure: Figure) : Figure by figure {} // Error : Only interfaces can be delegated to
class ByWindow(val byFigure: ByFigure) : ByFigure by byFigure {} // delegator, delegate
