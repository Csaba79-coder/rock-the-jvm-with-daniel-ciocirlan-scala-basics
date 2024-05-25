package lecture.part01basics

object Practice extends App {

  private val author: Writer = Writer("Agatha", "Christie", 1890)
  private val author2: Writer = Writer("Agatha", "Christie", 1890)
  private val novel: Novel = Novel("Cat Among the Pigeons", 1959, author)

  val age = novel.authorAge
  println(age)
  private val isWrittenBy = novel.isWrittenBy(author)
  println(isWrittenBy)
  private val isWrittenByOther = novel.isWrittenBy(Writer("Jane", "Austen", 1775))
  println(isWrittenByOther)

  private val isWrittenByInteresting = novel.isWrittenBy(author2)
  println(isWrittenByInteresting) // result is false!!! 2 different instance with same fields does not provide equality!

  private val counter: CounterOverLoaded = new CounterOverLoaded
  counter.inc.print // if no param, allowed to call methods without parenthesis!
  counter.inc.inc.inc.print // incr. the counter 3 times!
  counter.inc(10).print
  counter.dec(2).print // -2
  counter.inc(8).dec(2).print

  private class Writer(firsName: String, surName: String, val year: Int) {
    def fullName: String = Seq(firsName, surName).mkString(" ")
  }

  private class Novel(name: String, year: Int, author: Writer) {
    def authorAge: Int = year - author.year
    def isWrittenBy(author: Writer): Boolean = author == this.author
    def copy(newYear: Int): Novel = Novel(name, year, author)
  }

  private class Counter(val count: Int) {
    //def count: Int = count // its basically a getter!
    def inc: Counter = {
      println("incrementing") // using side effect for logging! and printing
      new Counter(count + 1)
    } // immutable! immutability is important: it is a new instance!!!

    def dec: Counter = Counter(count - 1)
    // instead of this, we would like to use overloaded not to repeat!
    def inc(value: Int): Counter = Counter(count + value)
    def dec(value: Int): Counter = Counter(count - value)
  }

  private class CounterOverLoaded(val count: Int = 0) { // adding default value, you dont have to define when instantiate!
    //def count: Int = count // its basically a getter!
    def inc: CounterOverLoaded = {
      println("incrementing") // using side effect for logging! and printing
      CounterOverLoaded(count + 1)
    } // immutable! immutability is important: it is a new instance!!!

    def dec: CounterOverLoaded = {
      println("decrementing")
      CounterOverLoaded(count - 1)
    }

    // instead of this, we would like to use overloaded not to repeat!
    def inc(value: Int): CounterOverLoaded = {
      if (value <= 0) this
      else inc.inc(value - 1)
    }

    def dec(value: Int): CounterOverLoaded = {
      if (value <= 0) this
      else dec.dec(value - 1)
    }

    def print = println(count)
  }
}
