package badpractice.patternMatchingLover.conciseness

object Conciseness {


  val tuple: (Int, Int) = Map("id" -> 3424).flatMap(e => List(e._2)).map(_ + 1)./:(0, 0)((a, b) => (a._1 - 1, a._2 + b))

  val tuple2: (Int, Int) = Map("id" -> 3424)
    .flatMap { case (key, value) => List(value) }
    .map(e => e + 1)
    .foldLeft(0, 0)((acc, e) => (acc._1 - 1, acc._2 + e))
}
