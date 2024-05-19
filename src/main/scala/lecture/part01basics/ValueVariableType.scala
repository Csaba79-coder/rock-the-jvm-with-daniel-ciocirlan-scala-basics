package lecture.part01basics

object ValueVariableType extends App {

  // compiler can infer types! (automatically, when omitted!)
  // type can be inferred!
  private val num: Int = 42 // val is immutable -> cannot be reassigned!
  println(num)

  val aString: String = "hello" // double quotes
  val anotherString: String = "goodbye"// own its own line! recommended, Scala style!
  val bString: String = "hey"; val cString: String = "ciao" // semicolon allowed, in this case mandatory, but not Scala way!

  val aBoolean: Boolean = true // or false!

  val aChar: Char = 'a' // single quotes
  val anInt: Int = num // -> 4 bytes!
  val aShor: Short = 4613 // represents on 2 bytes instead of 4 ... (smaller range!)
  val aLong: Long = 563411987 // double representation 8 bytes instead of 4
  val anotherLong: Long = 654497446646464L // with L at the end, its not Int anymore, can be higher number! (similar to Java syntax!)
  val aFloat: Float = 2.0f // lowercase f at the end, decimal nums if no f compiler recognize it as a double!
  val aDouble: Double = 2.0 // this is by default representation!

  // concept of variables!
  // we are working less with variables in functional programming!
  // in functional programming it is known as side effects! (there are danger of side effects!!!)
  var aVariable: Int = 4 // these are variables and not values as above!
  aVariable = 5 // can assign new value, not immutable!
  aVariable += 1 // as they are mutable!

  // TODO: prefer val over var!
}
