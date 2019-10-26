package badpractice.leastPower

import badpractice.leastPower.LeastPower.{Edge, Vertex}

object Syntax {

  implicit class EnrichEdge(val value: Edge) extends AnyVal {
    def print() = "Im a rich Edge too"
  }

  implicit class EnrichVertex(val value: Vertex) extends AnyVal {
    def print() = "Im a rich Vertex too"
  }

}

object test extends App {

  trait Foo[_]

  class Bar

  implicitly[Foo[Bar]]

  object Bar {
    //should add type annotation to work
    implicit val impFoo: Foo[Bar] = new Foo[Bar] {
    }
  }

}
