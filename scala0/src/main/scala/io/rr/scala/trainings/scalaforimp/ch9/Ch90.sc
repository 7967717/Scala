import scala.io.Source
import scala.sys.process

//val source = Source.fromFile("myfile.txt", "UTF-8")
val url = Source.getClass.getClassLoader.getResource("\\myfile.txt")
val source = Source.fromURL(url)

// The first argument can be a string or a java.io.File
// You can omit the encoding if you know that the file uses
// the default platform encoding

val lineIterator = source.getLines
val contents = source.mkString
while (lineIterator.hasNext) println(lineIterator.next())
//val contents = source.mkString
println(contents)
source.close()











