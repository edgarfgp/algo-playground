
import scala.collection.mutable

object Sieve {

    def primesNonRecursiveStream(end: Int): List[Int] = {
        val odds = LazyList.from(3, 2).takeWhile(_ <= Math.sqrt(end).toInt)
        val composites = odds.flatMap(i => LazyList.from(i * i, 2 * i).takeWhile(_ <= end))
        LazyList.from(3, 2).takeWhile(_ < end).diff(composites).toList
    }

    def primesIterative(end: Int): List[Int] = {
        val primeIndices = mutable.ArrayBuffer.fill((end + 1) / 2)(1)

        val intSqrt = Math.sqrt(end).toInt
        for (i <- 3 to end by 2 if i <= intSqrt) {
            for (nonPrime <- i * i to end by 2 * i) {
                primeIndices.update(nonPrime / 2, 0)
            }
        }

        (for (i <- primeIndices.indices if primeIndices(i) == 1) yield 2 * i + 1).tail.toList
    }
    def sieve(s: LazyList[Int]): LazyList[Int] =
        s.head #:: sieve(s.tail filter(_ % s.head != 0))

    def main(args: Array[String]): Unit = {
//        val primes = sieve(LazyList.from(2))
//        println(primes.take(100).toList)
//        val primes = primesIterative(100)
//        println(primes)
        val primes = primesNonRecursiveStream(100)
        println(primes)
    }
}
