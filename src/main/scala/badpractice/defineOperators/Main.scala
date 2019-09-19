package badpractice.defineOperators

object Main {
  def main(args: Array[String]): Unit = {
    val name = Property("name", Property.StringWrapper)
    val score = Property("score", Property.IntWrapper)

    val properties = Properties(
      name -> "Jean",
      score -> 10
    )
  }
}
