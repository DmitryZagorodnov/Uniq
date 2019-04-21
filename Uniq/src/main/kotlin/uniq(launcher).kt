import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.Option

class uniq{
    @Argument(required = true, usage = "Input file name")
    val file: Boolean = false

    @Option(name = "-o", usage = "Output file name", required = true)
    val o: Boolean = false

    @Option(name = "-i", usage = "Register no matters")
    val i: String? = null

    @Option(name = "-s", usage = "Ignore first symbols", required = true)
    val s: Boolean = false

    @Option(name = "-u", usage = "Only unique strings", required = true)
    val u: Boolean = false

    @Option(name = "-c", usage = "How many strings replaced by it", required = true)
    val c: Boolean = false

}


