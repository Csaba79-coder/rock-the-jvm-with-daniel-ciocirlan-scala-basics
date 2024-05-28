package lecture.part02oop

// universal concepts, universal functionality
object ObjectInScala extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY (does not know concept of "static" as in Java)
  // Object can hava a static like functionality
  // objects do not receive params!
  // they are singleton instances by definition! -> no code needed to define it!
  object Person { // what I define here its type, and also that is the only instance!
    // "static" or class-level functionality
    val NUM_EYES = 2
    def canFly: Boolean = false
    // often we have factory methods in the singleton object!
    // factory methods can build Persons! ... from the class!
    // the from method is called the factory method!
    def from(mother: Person, father: Person): Person = new Person("Bobbie")
    // instead of from it is usually called apply!!!
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  // often we write class and object with the same name! (in the same file or even in same scope!)
  class Person(val name: String) {
    // instance-level functionality
  }

  // COMPANIONS -> class and object with the same name! -> we achieve to get from regular or singleton instance at the same time!
  // as object is Singleton, that means companion object is Singleton as well!
  // companion design pattern!

  println(Person.NUM_EYES)
  println(Person.canFly)

  // object is used as a Singleton instance!
  val mary = Person // this is the instance of the person!
  val tom = Person
  println(mary == tom) // result is true, as they are pointing to the same instance! which is the object called Person!

  val mary2 = new Person("Mary")
  val tom2 = new Person("John")
  println(mary2 == tom2) // in this case it is false!!! as they are different instances!!!

  val bobbie = Person.from(mary2, tom2)
  val bobbie2 = Person.apply(mary2, tom2)
  val bobbie3 = Person(mary2, tom2) // it works only with apply!!!

  // Scala Applications! = Scala object with a particular method def main(args: Array[String]): Unit = {} implemented by default!
}
