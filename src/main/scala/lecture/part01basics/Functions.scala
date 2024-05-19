package lecture.part01basics

import scala.annotation.tailrec

object Functions extends App {

  def aFunctionBasic (aParam: String, bNum: Int) : String = aParam + " " + bNum

  // block is also an expression!

  def aFunction(aParam: String, bNum: Int) : String = { // function definition / header / signature
    aParam + " " + bNum // String concat! (avoid if possible!!!) this is impl. of the function!
  } // this was the code block!

  val separator = " "
  def concatString(aParam: String, bNum: Int): String = {
    Seq(aParam,  bNum).mkString(separator) // better approach instead of String concat!
  }

  val res1 = aFunctionBasic("hey", 3) // calling a function is also an expression! no matter if it is in println() or assign to a value!
  val res2 = aFunction("hey", 3)
  val res3 = concatString("hey", 3)
  println(res1)
  println(res2)
  println(res3)

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  println {
    aParameterlessFunction()
  }

  def aRepeatedFunction(aString: String, num: Int): String = {
    if (num == 1) aString
    else aString + aRepeatedFunction(aString, num - 1) // it is s recursive function!
  }

  // in Scala we use recursive function, instead of loops!
  // Fundamentals of functional programming: WHEN U NEED A LOOP, USE RECURSION! (fundamental idea of functional programming)
  // output: hey!hey!hey!hey!hey!hey! 6 times!
  println(aRepeatedFunction("hey!", 6)) // result is concatenated 6 times! no space, nothing, simply concat!

  def anotherRepeatedFunction(aString: String, num: Int): String = { // needs return type because of recursive function!
    aRepeatedFunction(aString, num - 1)
  }
  // output: hey!hey!hey!hey!hey! 5 times because of lack of if part!
  println(anotherRepeatedFunction("hey!", 6))

  // u do not need the return type of a function (explicitly knows!)! BUT you need the return type of a recursive function!
  // better to specify the return type of a function (for me, as better readability I will use for vals as well!)

  def aFunctionWithSideEffects(aString: String): Unit = {
    println(aString) // it shows result on console, but return type!!!
  }

  println(aFunctionWithSideEffects("Scala")) // do not forget, return type is ()

  def aBigFunction(num: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(num, num - 1)
  }

  println(aBigFunction(2)) // 3
  println(aBigFunction(5)) // 9

  private def greeting(name: String, age: Int): String = {
    s"Hi, my name is ${name} and I am ${age} years old."
  }

  private val greetingResult = greeting("Csaba", 45)
  println(greetingResult)

  private def factorial(num: Int): Int = {
    // 5 -> 5 * 4 * 3 * 2 * 1
    if (num <= 0) 1 else num * factorial(num - 1) // first part returns an integer, second one a product, that is also an integer
  }

  private val factorialNum = factorial(5) // output: 120
  println(factorialNum)

  // 1 1 2 3 5 8 13 21
  private def fibonacci(num: Int): Int = {
    // f(1) = 1
    // f(2) = 1
    // // f(n) = f(n - 1) + f(n - 2)
    if (num <= 2) 1 else fibonacci(num - 1) + fibonacci(num - 2)
  }

  private val fibonacciNum = fibonacci(5) // output: 5
  println(fibonacciNum)

  // It works without the tailrec annotation, but it helps the compiler optimize the recursion.
  private def isNumberPrime(num: Int): Boolean = {
    @tailrec // Ensures the function is tail-recursive for optimization
    def isPrimeUntil(number: Int): Boolean = {
      if (number <= 1) true else num % number != 0 && isPrimeUntil(number - 1)
    }
    isPrimeUntil(num / 2)
  }

  private val isPrimeFirst = isNumberPrime(5)
  private val isPrimeSecond = isNumberPrime(6)
  println(isPrimeFirst)
  println(isPrimeSecond)

  /*
  Tail recursion optimization means that the compiler transforms the recursive calls into a simple loop, which avoids
  creating a new stack frame for each call. This results in significant memory savings and prevents stack overflow errors,
  which is particularly important for large input values.

  When a tail-recursive function reaches its base case (e.g., number <= 1 in your example), it stops making recursive
  calls and simply returns the appropriate value.

  In the code it means: the base case for the isPrimeUntil function is if (number <= 1) true.
  When the number value is 1 or less, the function returns true and stops calling itself, thus ending the recursion.
  Tail recursion optimization helps in this process by ensuring that these recursive calls are converted into a loop
  by the compiler.

  How Tail Recursion Optimization Works:
  1. Base Case: When the number is 1 or less, the isPrimeUntil function returns true, and the recursion stops.
  2. Optimization: The @tailrec annotation ensures that the compiler converts the recursive calls into a loop,
  avoiding stack overflow and improving memory efficiency.

  Summary:
  Tail recursion optimization helps prevent infinite recursion and stack overflow errors, especially with large input
  values. The function returns when it reaches the base case (number <= 1), and it stops making recursive calls.
  */
}
