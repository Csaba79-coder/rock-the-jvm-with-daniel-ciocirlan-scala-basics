package lecture.part01basics

object Expressions extends App {

  private val x = 1 + 2 // the right hand-side is called the expression!
  println(x)

  // most basic expressions are maths expressions! BUT ...
  println(2 + 3 * 4) // preserve the ordering as in maths!
  // + - * / & (bitwise and) | (bitwise or) ^ (bitwise exclusive or)
  // << (bitwise left shift) >> (bitwise right shift) >>> (right shifting operation, specific to Scala! -> right shift with zero extension!)

  // there are also relational operations as well (not only mathematical ones) and some other!
  println(1 == x) // testing the equality ...
  // non equality !=
  // other: < > etc.

  // boolean operators - logical operators
  println(!(1 == x)) // logical negation
  // ! && ||
  var aVariable = 2
  aVariable += 3
  // += -= *= /= works only with variables!!! -----> these are the side effects!!!
  println(aVariable)

  // distinction between statements and instructions!
  // Instructions (DO) vs Expressions (VALUE)
  // Instruction: when you tell the computer to do (Java and Python works with instructions)
  // Expressions: every single code will compute a value!

  // IF expression!
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // it is if expression and not if statement nor if instruction
  println(aConditionValue)
  println(if (aCondition) 5 else 3)

  var i = 0
  var aWhile = while (i < 10) { // NEVER use it!!! it is more Java, Python or C syntax and not Scala!!! as Scala forces everything being an Expression!!!
    println(i)
    i += 1
  }

  println(aWhile) // as it is also Unit, output: () <-- while expression returns Unit ...

  // EVERYTHING in SCALA is an EXPRESSION!
  val aWeirdValue = (aVariable = 3) // Unit === void in Java
  println(aWeirdValue) // value of Unit is () and not a real value!!! --> output: () <-- this is the only value, that Unit type holds!
  // reason, the var is a side effect! as while loop as well!

  // side effects as follows: println(), whiles, reassigning (expressions, returning Unit! ...)

  // Code blocks: are special kind of expressions

  val aCodeBlock = { // code block is an expression!
    val y = 2 // visibility as in other languages, only in code block! cannot uses outside!
    val z = y + 1
    if (z > 2) "hello" else "goodbye" // value is the last expression! that occurs!
  }

  // instructions are executed (think Java), expressions are evaluated (Scala) -> means has a value as result!

  // difference between "hello world" and println("hello world") -> first is a String value, second is a side effect! Unit!

  val someValue = { // result is boolean, and it is true, as 2 is smaller than 3 ...
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 986
    46 // result is 46, as that is the last expression, so it is an Int!
  }
}

