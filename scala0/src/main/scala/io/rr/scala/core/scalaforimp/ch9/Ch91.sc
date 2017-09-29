import java.nio.file._

val dirname = "C:\\PerfLogs"

val entries = Files.walk(Paths.get(dirname)) // or Files.list

try {
  entries.forEach(p => println(p))
} finally {
  entries.close()
}