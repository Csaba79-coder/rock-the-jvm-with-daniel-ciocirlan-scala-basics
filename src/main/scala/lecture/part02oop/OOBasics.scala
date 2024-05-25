package lecture.part02oop

object OOBasics extends App {

  val people = new People // instantiate the class (new keyword!)
  val person = new Person("John", 26)
  //println(person.age)
  private val personWithAge = PersonSolution("John", 26)
  println(personWithAge.age) // solution is val! in the constructor!
  private val personWithFunc = PersonWithFunction("John", 26)
  println(personWithFunc.x)
  personWithFunc.greet("Daniel")
  personWithFunc.greet()
}

class People // organize data and behavior

class Person(name: String, age: Int) // constructor with param! age is a class param, but not a member -> person.age not ok!

//class PARAMS are not FIELDS

// keyword val is converting the param to field!

class PersonSolution(name: String, val age: Int)

// class are blueprints, data and functionality also known as (aka) behavior!

class PersonWithFunction(name: String, val age: Int) {
  // delimiter of class body is the curly braces!
  // its not an expression, but defines impl. of the class!
  val x = 2 // fields!
  // methods (i.e. functions)
  // expressions
  // other definitions. like packages, other classes, etc.
  println(1 + 3) // it is printed before the field! with instantiation all of them is evaluated and executed!

  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi, $name")
  }

  // it is overloading! important the scope! as usual ...
  def greet(): Unit = println(s"Hi, I am $name") // println(s"Hi, I am ${this.name}")

  // multiple constructor -> i.e overloading of the const.
  // it can be just a constructor and nothing else!!!
  // instead of this: other solution, if I give a default value in the primary constructor as 0!!! class PersonWithFunction(name: String, val age: Int = 0)
  // in this case, if age has a default value, this is not needed anymore: def this(name: String) = this(name, 0) I can solve it together!
  def this(name: String) = this(name, 0) // this is the way! it calls the original/primary constructor with only the name here!
  // the only implementation it can have:
  def this() = this("John Doe") // so just call the other constructor!
}