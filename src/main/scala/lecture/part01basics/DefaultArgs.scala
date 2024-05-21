package lecture.part01basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  private def tailRecFact(num: Int, acc: Int): Int = {
    if (num <= 1) acc
    else tailRecFact(num -1, num * acc)
  }

  // accumulator starts at 1 at every single time!
  private val fact10 = tailRecFact(10, 1)
  println(fact10)

  private def tailRecFactWithDefaultValue(num: Int, acc: Int = 1): Int = {
    if (num <= 1) acc
    else tailRecFact(num - 1, num * acc)
  }

  private val fact5 = tailRecFactWithDefaultValue(5) // it allows me to pass only the number! if I don't add acc, than it takes the default value of it!
  println(fact5)

  // but I can pass other param as well! as follows:
  private val fact5WithParam = tailRecFactWithDefaultValue(5, 2)
  println(fact5WithParam) // output: 240 multiplied by the accumulator itself! so the default value is overridden!

  private def savePicture(format: String, width: Int, height: Int): Unit = {
    println("saving picture")
  }

  savePicture("jpg", 800, 600)

  // if most of the time it is called with same param! it is useful!
  // if most of the time it is jpeg! ...
  private def savePic(format: String = "jpeg", width: Int, height: Int): String = {
    s"saving picture in ${format}"
  }

  /*
  Solutions:
  1. pass in every leading argument
  2. name the arguments
  */

  /*
  lecture.part01basics.DefaultArgs$$$Lambda/0x000001951a098e08@3cda1055, is a representation of a lambda function
  (anonymous function) in Scala. When you write private val jpeg = savePic(_, 600, 600), you're creating a partially
  applied function, which means you're not calling the function immediately but rather defining a function that will call
  savePic with the format parameter when it's provided later.
  */
  private val jpeg = savePic(_, 600, 600) // _ can be used as the default value!
  println(jpeg) // output: lecture.part01basics.DefaultArgs$$$Lambda/0x000001951a098e08@3cda1055
  // solution:
  println(jpeg("jpeg")) // output: saving picture in jpeg

  private val png = savePic("png", 600, 600)
  println(png)

  private val namedArgs = savePic(width = 600, height = 600)
  println(namedArgs) // this provides the correct output as follows: saving picture in jpeg

  // side effect of being named of the argument:
  savePic(height = 600, width = 800, format = "bmp") // nice side effect, order does not matter! it is a side feature!
}
