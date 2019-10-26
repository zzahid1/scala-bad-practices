package badpractice

object Test {

  case class Demo(id: String)

  object Demo {
    def apply(id: String): Demo = Demo(id + "bbb")
  }

  def main(args: Array[String]): Unit = {
    val d = Demo("aaa")
    println(d)
  }

}
