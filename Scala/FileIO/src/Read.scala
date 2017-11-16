import scala.io.Source
object Read{
  def main(args: Array[String]): Unit = {
    val in = Source.fromFile("test.txt").bufferedReader()
    var size = 0
    while(in.read() != -1)  size+=1
    in.close()
    println("Size: "+size+"Byte")
  }
}
