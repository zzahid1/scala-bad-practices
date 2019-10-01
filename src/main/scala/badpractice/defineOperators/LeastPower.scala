package badpractice.defineOperators

object LeastPower extends App {


  case class Edge()

  case class Vertex()

  case class RichEdge() {
    def show = "Im a Rich Edge"
  }

  case class RichVertex() {
    def show = "Im a Rich Vertex"
  }


  implicit def RichEdge(edge: Edge): RichEdge = RichEdge()

  implicit def RichVertex(vertex: Vertex): RichVertex = RichVertex()


  println(Edge().show)
  println(Vertex().show)

  println(Edge().print())
  println(Vertex().print())

  implicit case class EnrichEdge(value: Edge) extends AnyVal {
    def print() = "Im a rich Edge too"
  }

  implicit case class EnrichVertex(value: Vertex) extends AnyVal {
    def print() = "Im a rich Vertex too"
  }


  def createVertex(): RichVertex =
    {
      // could be a mismatch error return
      Vertex()
    }

}
