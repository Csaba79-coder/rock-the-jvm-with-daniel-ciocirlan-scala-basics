package lecture.part02oop

import scala.annotation.targetName
import scala.language.postfixOps

object MethodNotation extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    @targetName("concatenate")
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    @targetName("likes")
    def ++(person: Person): String = s"${this.name} likes ${person.name}"
    def ?(person: Person): String = s"${this.name} asks ${person.name}: but why?"
    def unary_! : String = s"$name what the heck?!"  // space is important after the unary_! if no space means column (:) is a part of the method's name
    def isAlive: Boolean = true // the function not receives any params!
    // method signature is important bellow:
    def apply(): String = s"Hi, my name is: $name and I like $favoriteMovie"// here parenthesis are important for the method!!!
  }

  private val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // infix notation or operator notation (only works with method that has exactly one param!) -> syntactic sugar!
  println(mary likes "Inception") // equivalent!

  // "operators" in Scala
  private val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom) // hangOutWith behaves as an operator, and yielding a String here!

  // in Scala there is a permissive method naming scheme!
  println(mary + tom)
  println(mary.+(tom)) // exactly same as above!
  println(mary ++ tom)

  // in case of nums:
  println(1 + 2)
  // hit control + space and gives all available methods!
  println(1.+(2)) // + can be used as a method ... mathematical operators ara acting as a method!

  println(mary ? tom)

  // AKKA actors have ! ?

  // prefix notation (other form of syntactic sugar!):
  // unary operators!
  /*
  Unary operators are operators which are used to calculate the result on only one operand.
  Unary operators are used on a single operand in order to calculate the new value of that variable.
  */
  val x = -1 // the negative sign is a unary operator here! and these are also methods!
  // unary_ works with a few operators as follows: - + ~ (tilda) ! (bang)
  val y = 1.unary_-
  println(x) // output: -1
  println(y) // output: -1

  println(!mary) // both guy is equivalent!
  println(mary.unary_!)

  // postfix notation:
  println(mary.isAlive)
  // in Scala 3 needs the import: import scala.language.postfixOps
  println(mary isAlive) // syntactic sugar! -> methods without params!

  // method apply is a special one!
  println(mary.apply()) // output: Hi, my name is: Mary and I like Inception
  println(mary) // output: lecture.part01basics.MethodNotation$Person@668bc3d5
  // I can call mary as method, because this has an apply method!
  // whenever compiler see an object called as a function it looks for definition of apply! in that particular class!
  // apply is special thing in Scala!
  println(mary()) // output: Hi, my name is: Mary and I like Inception -> brakes the barrier between oop and functional programming!
}
