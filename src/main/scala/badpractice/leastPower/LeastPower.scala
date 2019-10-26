package badpractice.leastPower

object LeastPower extends App {


  final case class Arc()

  final case class Node()

  case class RichArc() {
    def show = "Im a Rich Arc"
  }

  case class RichNode() {

    def show: String = "Im a Rich Node"
  }

  implicit def RichArc(arc: Arc): RichArc = RichArc()

  implicit def RichNode(node: Node): RichNode = RichNode()

  def createRichNode(): RichNode = {
    // could be a mismatch error return
    Node()
  }
}
