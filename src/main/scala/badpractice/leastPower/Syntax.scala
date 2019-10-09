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
