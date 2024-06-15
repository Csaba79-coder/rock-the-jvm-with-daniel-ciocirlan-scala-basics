package lecture.part02oop

object InheritanceAndTrait extends App {

  // Single class inheritance -> only extend one class at a time

  class Animal {
    val creatureType = "wild"
    def eat = println("nomnom") // if it is protected, this class and subclasses, private only this class!
  }

  // Cat is a subclass of Animal, and Animal is a superclass of Cat
  class Cat extends Animal

  val cat = new Cat
  cat.eat // only extends the non private members of a superclass!

  class Animal2 {
    protected def eat = println("nomnom2")
  }

  class Cat2 extends Animal2 {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  // access modifiers no modifier (by default public), protected and private!
  val cat2 = new Cat2
  cat2.crunch

  // constructors!
  class Person(name: String, age: Int)
  // class Adult(name: String, age: Int, idCard: String) extends Person -> it wont compile!!!
  // Adult is also know as derived class!!! and when you instantiate Adult, you need to call the constructor of the parent class first!
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) // correct way to extend a class with params!

  class Person2(name: String, age: Int) {
    def this(name: String) = this(name, 0)// Auxiliary Class Constructors
  }

  class Adult2(name: String, age: Int, idCard: String) extends Person2(name) // can be both params. or because of auxiliary constructor, one is enough!

  class Adult3(name: String, age: Int, idCard: String) extends Person2(name, age)

  // overriding -> methods, values, vars
  class Dog extends Animal {
    override val creatureType: String = "domestic"
    override def eat: Unit = println("crunch, crunch")
  }

  val dog = new Dog
  dog.eat
  println(dog.creatureType)
  println(cat.creatureType)

  class Dog2(override val creatureType: String) extends Animal {
    override def eat: Unit = println("crunch, crunch")
  }

  val dogK9 = new Dog2("K9")
  println(dogK9.creatureType)

  class Dog3(dogType: String) extends Animal {
    override val creatureType: String = dogType
    override def eat: Unit = println("crunch, crunch")
  }
  val dog3 = new Dog3("K9")
  println(dog3.creatureType)

  // no matter to override directly the method, it is possible to call the super method as well!
  class Dog4(dogType: String) extends Animal2 {
    val creatureType: String = dogType
    override def eat: Unit = {
      super.eat
      println("crunch, crunch")
    }
  }
  val dog4 = new Dog4("K9")
  println(dog4.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog2("K9") // uses dog's methods, but the type is Animal
  unknownAnimal.eat // derived implementation of eat is called!

  // overRIDING vs overLOADING
  // super class has a method, and subclass has a method with the same name, and same signature!
  // overloading is multiple methods with the same name, but different signatures!
  // super class has a method, and subclass has a method with the same name, but different signature!
  // super
  // super is a keyword in Scala, which is used to refer to the immediate parent class object.
  // It is used to call the members of the parent class, explicitly.
  // super is used to call the constructor of the parent class and to call the methods of the parent class.
  // super is used to call the parent class constructor from the child class.
  // super is used to call the parent class method that is overridden by the child class.
  class Dog5 extends Animal {
    override def eat: Unit = {
      super.eat
    }
  }

  val dog5 = new Dog5
  dog5.eat

  // preventing overrides
  // 1. use final on member
  // 2. use final on the entire class
  // 3. seal the class = extend classes in THIS FILE, prevent extension in other files
  // sealed class Animal3 -> it is possible to extend it in this file, but not in other files!
  // it is a good practice to seal the class, if you want to prevent the extension of it!
  class People {
    final def eat = println("nomnom")
  }

  class Kid extends People {
    // override def eat = println("nomnom") // it wont compile!
    super.eat // super can be called!!! but cannot override it!
  }

  final class People2 {
    def eat = println("nomnom")
  }

  // if the class is final the subclass cannot inherit from it! and it is not possible to override the method!
  /*class Kid2 extends People2 {
    def eat = println("nomnom")
  }*/ // compile error! cannot inherit from final class People2

  // seal the class! -> it is possible to extend it in this file, but not in other files!
  sealed class People3 {
    def eat = println("nomnom")
  }
  class Kid3 extends People3
  val kid3 = new Kid3
  kid3.eat
}
