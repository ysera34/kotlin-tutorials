fun main(args: Array<String>) {
    val instance1 = InvokeOperator("Camerarius barcass ducunt ad adiurator.")
    instance1("Salvus consiliums ducunt ad saga.")
}

class InvokeOperator(val makeMessage1: String) {
    operator fun invoke(makeMessage2: String) {
        println("$makeMessage1 $makeMessage2!")
    }
}
