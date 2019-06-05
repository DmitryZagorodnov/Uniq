import java.io.File
import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option
import java.io.Writer
import java.util.*

class Uniq {
    @Argument(required = false, usage = "Input File Name")
    private val file: String? = null

    @Option(name = "-o", usage = "Output File Name")
    private val outputFile: String? = null

    @Option(name = "-i", usage = "Register No Matters")
    private val i: Boolean? = null

    @Option(name = "-s", usage = "No Compare First N Symbols")
    private val s: Boolean? = null

    @Argument(required = false, usage = "How Many First Symbols Won't Compare")
    private val n: Int? = null

    @Option(name = "-u", usage = "Only Unique Strings")
    private val u: Boolean? = null

    @Option(name = "-c", usage = "Firstly Will Write How Many Strings Was Replaced By This")
    private val c: Boolean? = null


    fun launch(args: Array<String>) {
        val parser = CmdLineParser(this)
        try {
            parser.parseArgument(*args)
        } catch (e: CmdLineException) {
            System.err.println(e.message)
            parser.printUsage(System.err)
            return
        }
        var writer = System.out.bufferedWriter()
        if (outputFile != null) {
            writer = File(outputFile).bufferedWriter()
        }
        var input: Scanner
        var string: String?
        var previousString: String? = null
        var count = 1
        val list = mutableListOf<String>()
        if (file != null) input = Scanner(File(file))
        else input = Scanner(System.`in`)
        string = input.nextLine()

        while (string != null) {

            if (i == true) {
                string.toLowerCase()
            }

            if (s == true) {
                string = string.substring(n!!)
            }

            if (((u == true) && (string !in list)) || (u == false)) {
                if (u == true) list += string

                if (previousString == string && u != true) {
                    count++
                } else {
                    if (c == true) {
                        writer.write("$count" + previousString)
                    } else {
                        writer.write(previousString)
                    }
                }
            }
            previousString = string
            string = input.nextLine()
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            Uniq().launch(args)
        }
    }
}


