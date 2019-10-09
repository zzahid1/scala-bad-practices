package badpractice.leastPower

object LeastPower extends App {


  final case class Edge()

  final case class Vertex()

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


  import Syntax._

  println(Edge().print())
  println(Vertex().print())


  def createVertex(): RichVertex = {
    // could be a mismatch error return
    Vertex()
  }

}
