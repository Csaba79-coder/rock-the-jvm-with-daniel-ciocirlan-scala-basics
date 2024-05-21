package lecture.part01basics

object StringOperation extends App {

  val str: String = "Hello, I am learning Scala"

  // Java function, as it runs on JVM can have access to Java String
  println(str.charAt(2)) // output: l
  println(str.substring(7, 11)) // first is inclusive, second is exclusive! output: I am
  println(str.split(" ")) // split at delimiter! this returns an array, that is not printable ... output: [Ljava.lang.String;@380fb434
  println(str.split(" ").toList) // output: List(Hello,, I, am, learning, Scala)
  println(str.split(" ").toSeq) // output: ArraySeq(Hello,, I, am, learning, Scala)
  println(str.startsWith("Hello")) // output: true
  println(str.replace(" ", "-")) // output: Hello,-I-am-learning-Scala
  println(str.toLowerCase) // output: hello, i am learning scala
  println(str.length) // output: 26

  // Scala based functions:
  private val aNumberString = "45"
  val aNumber = aNumberString.toInt // converting directly String to Int
  println('a' +: aNumberString :+ 'z') // prepending and appending operators! it is a Scala specific!
  println(str.reverse) // a Scala specific utility function
  println(str.take(2)) // output: He

  // Scala-specific: String interpolator
  // S-interpolator
  val name = "Chad"
  val age = 45
  val greeting = s"Hello, my name is $name and I am $age years old" // S-interpolated String
  println(greeting)
  private val anotherGreeting = s"Hello, my name is $name and I will be ${age + 1} years old" // in curly braces any expression I want!
  println(anotherGreeting)
  private val fullNameGreeting = s"Hello, my name is ${name + " Hunter"} and I will be turning ${age + 1} years old"
  println(fullNameGreeting)

  // F-interpolator
  private val speed = 1.2f
  private val myth = f"$name%s can eat $speed%2.2f burgers per minute" // formatting!
  println(myth)

  val x = 1.1f // in string format for float use f!
  //val strFromX = f"$x%3d" // format requires int, so it cannot be used! d is an Int! x is highlighter by the IDE ...
  val y = 1
  private val strFromY = f"$y%3d" // space space 1
  println(strFromY)
  private val strFromYOther = f"$y%2d" // space 1
  println(strFromYOther)

  // Raw-interpolator
  println(raw"This is a \n newLine") // it is printing literally ... so \n is not a new line escape character here!
  private val escaped = "This is a \n newLine" // here is is ignores escape ...
  // in case of injected values, they do get escaped!
  println(escaped) // printed in 2 lines!
  println(raw"$escaped") // printed in 2 lines!
}
