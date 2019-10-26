package badpractice.defineOperators

import badpractice.defineOperators.Prop.{IntWrap, StrWrap}

object Main {
  def main(args: Array[String]): Unit = {
    val name: Prop[String] = Prop("name", StrWrap)
    val score: Prop[Int] = Prop("score", IntWrap)

    val props = Props(
      name -> "Jean",
      score -> 10)

    props.in
  }
}
