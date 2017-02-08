package main

import java.util

object Startup {

  def sort(xs: Array[Int]): Array[Int] = {
    if(xs.length <= 1) xs
    else {
      val pivot = xs(xs.length/2);
      Array.concat(sort(xs.filter(pivot >)), sort(xs.filter(pivot <)))
    }
  }

  def While (p: => Boolean) (s: => Unit) {
    if(p) { s; While(p)(s)}
  }


  def main(args: Array[String]): Unit = {
    println("Hello world")

    lazy val expensiveStuff =  for (i <- List.range(0, 10) if i % 2 == 0) yield i
    println(expensiveStuff)

    for(i <- 1 to 10){
      println(expensiveStuff(i))
    }


    Console.in.read()
  }


}



