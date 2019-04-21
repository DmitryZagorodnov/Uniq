import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import java.io.File

fun main(args: Array<String>) {
    var bean = uniq()
    val parser = CmdLineParser(bean)
    try {
        parser.parseArgument(*args)
    } catch (error: CmdLineException) {
        System.err.println(error.message)
        return
    }

    fun i(inputName: String) {
        File(inputName).readText().toLowerCase()
    }

    fun s(n: Int, inputName: String, outputName: String) {
        val f = File(inputName).readLines()
        File(outputName).bufferedWriter().use {
            for (line in f) {
                it.write(line.substring((n + 1), line.length))
                it.newLine()
            }
        }
    }

    fun u(inputName: String, outputName: String) {
        val f = File(inputName).readLines()
        var map = mutableMapOf<String, Int>()
        File(outputName).bufferedWriter().use {
            for (line in f) {
                if (line !in map) {
                    map[line] = 1
                } else map[line] = (map[line]!! + 1)
            }
            for ((line, number) in map) {
                if (number == 1) it.write(line)
                it.newLine()
            }
        }
    }

    fun c(inputName: String, outputName: String) {
        val f = File(inputName).readLines()
        var map = mutableMapOf<String, Int>()
        File(outputName).bufferedWriter().use {
            for (line in f) {
                if (line !in map) {
                    map[line] = 1
                } else map[line] = (map[line]!! + 1)
            }
            for ((line, number) in map) {
                if (number == 1) {
                    it.write(line); it.newLine()
                } else it.write("$number $line")
            }
        }
    }


    fun uniq(inputName: String, outputName: String) {
        val f = File(inputName).readLines()
        val map = mutableMapOf<String, Int>()
        val list = mutableListOf<String>()
        var a = ""
        for (line in f) {
            if (line !in map) {
                map[line] = 1
                list += line
                a = line
            } else {
                map[line] = map[line]!! + 1
                if (a != line) {
                    list += line; a = line
                }
            }
        }
    }
}
