package lecture.part02oop

object AbstractDataType extends App {

  // abstract
  // cannot be instantiated
  abstract class Animal {
    val creatureType: String
    def eat: Unit // unimplemented method -> abstract method
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine" // override keyword is optional not mandatory
    override def eat: Unit = println("crunch, crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit // traits by default are abstract
    val preferredMeal: String = "fresh meat" // non abstract member
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Croc"
    override def eat: Unit = println("nomnomnom")
    override def eat(animal: Animal): Unit = println(s"I am a croc and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1 - traits do not have constructor parameters
  // 2 - multiple traits may be inherited by the same class (multiple traits = "mixins")
  // 3 - traits = behavior, abstract class = "thing"

  // abstract and trait can have abstract and non-abstract members
  // multiple trait inheritance is possible but only single class inheritance allowed!

  // Scala's type hierarchy
  // scala.Any -> scala.AnyRef (java.lang.Object) -> scala.Null
  // scala.Any -> scala.AnyVal -> scala.Unit, scala.Boolean, scala.Char, scala.Byte, scala.Short, scala.Int, scala.Long, scala.Float, scala.Double
  // scala.Nothing -> scala.Null
  // scala.Null is a subtype of scala.AnyRef
  // scala.Nothing is a subtype of every other type
  // scala.Null is a subtype of every other type except scala.Value types

  // Any is the mother of all types!
}
