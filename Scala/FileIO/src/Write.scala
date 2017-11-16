import java.io.{BufferedWriter, FileWriter}
object Write {
  def main(args: Array[String]): Unit = {
    val out = new BufferedWriter(new FileWriter("test.txt"))
    var GB = 1*1024*1024*1024
    var size = 0
    while(GB!=0) {
      out.write('A')
      size+=1
      GB-=1
    }
    out.close()
    println("Size: "+size)
  }
}
