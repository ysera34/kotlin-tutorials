var propertyCount = 100
    get() {
        println("get accessor of propertyCount")
        return field
    }
    set(value) {
        println("set accessor of propertyCount")
        field = value
    }

fun main(args: Array<String>) {
    println("propertyCount: $propertyCount")

    var fieldCount = 100
    println("fieldCount: $fieldCount")
    fieldCount += 200
}