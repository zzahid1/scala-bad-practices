package badpractice.applyMisuse

import badpractice.applyMisuse.ApplyMisuse.Node

import scala.util.Try

object ApplyMisuse {

  case class RichArc(id: String, name: String, in: Option[Node], out: Option[Node])

  object RichArc {
    def from(id: String, name: String): Try[RichArc] = {
      nodeRepo.getNodes(id).map { case (in, out) => RichArc(id, name, in, out) }
    }
  }

  case class RichNode(id: String, name: String)

  case class Node(id: String, name: String)

  object Arc {

    def apply(id: String, name: String): RichArc = {
      val (in, out) = nodeRepo.getNodes2(id) // throws :(
      RichArc(id, name, in, out)
    }
  }

  def main(args: Array[String]): Unit = {
   val arc = Arc("id", "name") // return RichArc !!!
  }

  case class Arc(id: String, name: String, in: Node, out: Node)


}

object nodeRepo {
  def getNodes(id: String): Try[(Option[Node], Option[Node])] = ???
  def getNodes2(id: String): (Option[Node], Option[Node]) = ???
}
