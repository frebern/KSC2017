object Benchmark{

  def primeStream(primes: Stream[Long] = Stream.from(3, 2).map(_.toLong)): Stream[Long] = 2 #:: {
    def isPrime(p:Long):Boolean = {
      val sqrtPrime = Math.sqrt(p)
      !primeStream(primes).takeWhile(_<=sqrtPrime).exists(p%_==0)
    }
    primes.head #:: primes.tail.filter(isPrime)
  }

  def main(args: Array[String]): Unit = {
    val nth = 100000
    println(primeStream().take(nth).last)
  }

}
