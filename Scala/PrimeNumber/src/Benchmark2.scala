import scala.annotation.tailrec

object Benchmark2{

  def isPrime(p:Long, primes:List[Long]):Boolean = {
    val sqrtPrime = Math.sqrt(p)
    !primes.dropWhile(_>sqrtPrime).exists(p%_==0)
  }

  @tailrec
  def nextPrime(prev:Long, primes:List[Long]): Long =
    if(isPrime(prev+2, primes)) prev+2
    else nextPrime(prev+2, primes)

  @tailrec
  def nthPrime(nth: Int, primes:List[Long]): Long =
    if(primes.size >= 2)
      if(nth<=primes.size) primes.head
      else nthPrime(nth, nextPrime(primes.head, primes) :: primes)
    else
      nthPrime(nth, List(3, 2))

  def main(args: Array[String]): Unit = {
    val nth = 100000 //Too slow to get 10,000,000th Prime
    println(nth+"th Prime Number: "+nthPrime(nth, List()))
  }

}
