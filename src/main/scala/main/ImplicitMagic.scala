package main

import java.util
import collection.JavaConverters._

case class Something(name: String) {

}

case class Nothing(name: String) {

}

object ImplicitMagic {
  implicit def listOfSomethingToNothing(x:util.ArrayList[Something]): Seq[Nothing] = {
    val converted = x.asScala.map(x=>new Nothing(x.name))
    converted
  }

  // get index takes some collection and a value which is inside
  // it assumes there is a conversion between that collection and a Seq[T] type available
  def getIndex[T, CC](seq: CC, value: T) (implicit  conv: CC => Seq[T]) =
    seq.indexOf(value)


  def testImplicits: Unit = {
    val values = new util.ArrayList[Something]()
    getIndex(values, new Nothing("name"))
  }
}
