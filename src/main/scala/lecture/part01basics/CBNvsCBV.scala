package lecture.part01basics

object CBNvsCBV extends App {

  // type is Long as param!
  // the exact value of the expression is computed, before the function evaluates! -> same value is used in the function definition!
  private def calledByValue(num: Long): Unit = { // function with side effect
    println("by value: " + num)
    println("by value: " + num)
  }

  // arrow makes the difference!
  // by name call: the expression is passed literally, as is! -> expression evaluate every time! when its used!
  // useful in lazy streams! (at Try type will be important!)
  private def calledByName(num: => Long): Unit = {
    println("by name: " + num)
    println("by name: " + num)
  }

  /*
  by value: 262920131473200
  by value: 262920131473200
  */
  calledByValue(System.nanoTime()) // this returns a value, and printed twice!
  /*
  by name: 262920181986400
  by name: 262920182708000
  */
  calledByName(System.nanoTime()) // printed twice, but different values, as time passing!

  private def infinite(): Int = 1 + infinite()
  private def printFirst(numByValue: Int, numByName: => Int) = println(numByValue)
  // printFirst(infinite(), 34) // StackOverflowError!
  printFirst(34, infinite()) // output: 34 infinite() will never evaluate! that reason WE DO NOT GET StackOverflowError

  // Call by name is used:
  /*
  1. Lazy Evaluation
  Call by name is beneficial when you want to delay the evaluation of an argument until it is actually used within the
  function. This is particularly useful for optimizing performance when the argument is computationally expensive to
  evaluate and might not always be needed.
  2. Control Structures
  Call by name is useful for implementing custom control structures that require lazy evaluation, such as loops,
  retries, or conditionals.
  3. Resource Management
  Call by name can be useful in resource management patterns, such as ensuring that resources are properly closed after use.
  4. Default Arguments
  Call by name can be used to provide default arguments that are computed lazily.

  Conclusion
  Call by name is a powerful feature in Scala that enables lazy evaluation, custom control structures, efficient
  resource management, and lazy default arguments. Use it when you need to delay evaluation of an argument until it is
  actually needed, which can lead to more efficient and expressive code.
  */
}
