package badpractice.leastPower

object LeastPower extends App {


  final case class Arc()

  final case class Node()

  case class RichArc() {
    def show = "Im a Rich Arc"
  }

  case class RichNode() {

    def show = "Im a Rich Node"
  }

  implicit def RichEdge(edge: Arc): RichArc = RichArc()

  implicit def RichVertex(vertex: Node): RichNode = RichNode()

  def createVertex(): RichNode = {
    // could be a mismatch error return
    Node()
  }


  println(Arc().show)
  println(Node().show)


  import Syntax._

  val node = RichNode("42")

  println(Arc().show())
//  println(Node().print())

}
