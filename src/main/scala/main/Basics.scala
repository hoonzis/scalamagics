package main

import scala.math._

object Basics {
  def sqrt(x:Double) =
  {
    def sqrtIter(guess:Double, x:Double) = {
      if(isGoodEnough(guess,x)) guess
      else improove(guess, x)
    }

    def improove(guess: Double, x:Double) = guess + x / guess / 2
    def isGoodEnough(guess: Double, x: Double) =
      abs(guess*guess - x) < 0.001
  }

  def gcd(a:Int, b:Int): Int = if (b == 0) a else gcd (b, a % b)

  def factorial(n: Int) : Int =
    if(n == 0) 1
    else n*factorial(n-1)

  def tail_rec_fact (n: Int, soFar: Int): Int =
    if(n == 1) soFar else tail_rec_fact(n-1, soFar * n)


  // currying example. give a function that will some everything
  // calculated with passed parameter in certain range

  // manual currynig
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }

  // curryied by the compiler. passing parameters from the left
  // two paramater lists here
  def sum2(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum2(f)(a + 1, b)


  def sumSquares = sum(x => x*x)

  // fixed point calculation, defining sqrt in the means of fixed point of x/y
  val tolerance = 0.0001
  def isCloseEnough(x: Double, y: Double) = Math.abs((x - y) / x) < tolerance
  def fixedPoint(f: Double => Double)(firstGuess: Double) = {
    def iterate(guess: Double): Double = {
      val next = f(guess)
      println(next)
      if (isCloseEnough(guess, next)) next
      else iterate(next)
    }
    iterate(firstGuess)
  }

}

