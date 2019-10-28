package badpractice.conciseness

object Conciseness {

  case class User(name: String, age: Int)


  val tuple: (Int, Int) = Map("id" -> ("badr", 13))
    .flatMap(e => List(e._2))
    .map(_._2 + 1)
    ./:((0, 0))((a, b) => (a._1 - 1, a._2 + b))

  val tuple2 = Map("id" -> User("badr", 13))
    .flatMap { case (_, value) => List(value) }
    .map(user => user.age)
    .foldLeft((0, 0))((acc, e) => (acc._1 - 1, acc._2 + e))
}


