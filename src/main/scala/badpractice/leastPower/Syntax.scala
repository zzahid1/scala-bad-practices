package badpractice.leastPower

import badpractice.leastPower.LeastPower.{Arc, Node}

object Syntax {

  implicit class EnrichEdge(val value: Arc) extends AnyVal {
    def show() = "Im a rich Edge too"
  }

  implicit class EnrichVertex(val value: Node) extends AnyVal {
    def show() = "Im a rich Vertex too"
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
