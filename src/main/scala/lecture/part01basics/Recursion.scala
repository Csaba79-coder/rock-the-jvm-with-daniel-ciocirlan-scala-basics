package lecture.part01basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(num: Int): Int = {
    if (num <= 1) 1
    else {
      println(s"Computing factorial of ${num} - I first need a factorial of ${num - 1}")
      val result = num * factorial(num -1)
      println(s"Computed factorial of ${num}")
      result
    }
  }

  println(factorial(10))
  // println(factorial(5000)) //<- StackOverflowError due to memory! if recursive depth is too big! after some point it comes

  // it has a limitation, but we have to write code on a smart way!
  // new concept!!!
  private def anotherFactorial(num: Int): Int = {
    @tailrec
    def factorialHelper(number: Int, accumulator: Int): Int = {
      if (number <= 1) accumulator
      else factorialHelper(number - 1, number * accumulator)
    }
    factorialHelper(num, 1)
  }

  /*
  Explanation:
  anotherFactorial(10) = factorialHelper(10, 1)
  => this means factorialHelper(9, 10 * 1)
  => this means factorialHelper(8, 9 * 10 * 1)
  => this means factorialHelper(7, 8 * 9 * 10 * 1)
  => ... (goes until 2!!!)
  => this means factorialHelper(2, 3 * 4 * ... * 8 * 9 * 10 * 1)
  and comes one final recursive call:
  => this means factorialHelper(1, 2 * 3 * 4 * ... * 8 * 9 * 10 * 1) at this point the accumulator becomes 1 so it will go to if branch instead of else!
  => and this will return the accumulator itself! i.e.: 1 * 2 * 3 * 4 * ... * 8 * 9 * 10 // it implements the factorial definition itself!
  */

  private val resBigNum = anotherFactorial(5000)
  println(resBigNum) // result is 0, because we run out of int representation! it overflows integer representation!

  // solution is BigInt!!!
  // DO NOT FORGET to replace the factorial helper method's return value and the accumulator itself to BigInt as well!
  private def anotherFactorialHugeNum(num: Int): BigInt = {
    @tailrec
    def factorialHelper(number: Int, accumulator: BigInt): BigInt = {
      if (number <= 1) accumulator
      else factorialHelper(number - 1, number * accumulator)
    }

    factorialHelper(num, 1) // this is the tail! if not tail recursion, compiler gives error!
  }

  private val notOutOfIntRepresentation = anotherFactorialHugeNum(5000)
  println(notOutOfIntRepresentation)
  private val notOutOfIntRepresentationMoreHuge = anotherFactorialHugeNum(20000)
  println(notOutOfIntRepresentationMoreHuge)

  // when you need loops, use tail recursion! (sometimes you need more then one accumulator!)

  // using tail recursion as follows:

  @tailrec
  private def concatenateTailRec(aString: String, num: Int, accumulator: String): String = {
    if (num <= 0) accumulator
    else concatenateTailRec(aString, num - 1, aString + accumulator)
  }

  println(concatenateTailRec("Hey", 3, ""))

  private def isPrime(num: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(number: Int, isStillPrime: Boolean): Boolean = {
      if (! isStillPrime) false
      else if (number <= 1) true
      else isPrimeTailRec(number - 1, num % number != 0 && isStillPrime)
    }
    isPrimeTailRec(num / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  private def fibonacciNumber(num: Int): Int = {
    @tailrec
    def fibonacciTailRec(index: Int, accumulatorLast: Int, accumulatorNextToLast: Int): Int = {
      if (index >= num) accumulatorLast
      else fibonacciTailRec(index + 1, accumulatorLast + accumulatorNextToLast, accumulatorLast)
    }
    if (num <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }

  println(fibonacciNumber(8)) // 1 1 2 3 5 8 13 21
}
