package badpractice.castSurprise

import scala.util.Try

object CastSurprise {
  def main(args: Array[String]): Unit = {
    val res = new Result()
    res.setProperty("int", 1)
    println("""res.setProperty("int", 1)""")
    println()

    val v: Int = res.getProperty[Int]("int") // nominal case
    val m: Int = res.getProperty[Int]("bad") // wrong name => null, ok // TODO 0!!!
    val s: Try[String] = Try(res.getProperty[String]("int")) // wrong type => ClassCastException, ok
    println(s"""    res.getProperty[ Int  ]("int")  : $v""")
    println(s"""    res.getProperty[ Int  ]("bad")  : $m""")
    println(s"""Try(res.getProperty[String]("int")) : $s""")
    println()

    // let's use Option to manage the null

    val vo: Option[Int] = Option(res.getProperty[Int]("int")) // nominal case with Option => Some(1), ok
    val mo: Option[Int] = Option(res.getProperty[Int]("bad")) // wrong name with Option => None, ok
    val so: Option[String] = Option(res.getProperty[String]("int")) // wrong type with Option => Some(1), LOL, WAT???
    println(s"""Option(res.getProperty[ Int  ]("int")): $vo""")
    println(s"""Option(res.getProperty[ Int  ]("bad")): $mo""")
    println(s"""Option(res.getProperty[String]("int")): $so""")
    println()

    // let's use our IntString ^^

    val is = Try(so.get)
    val clazz = Try(so.get.getClass)
    val modified = Try(so.get + "m")
    println(s"""so.get           : ${so.get} vs $is""")
    println(s"""so.get.getClass  : ${so.get.getClass} vs $clazz""")
    println(s"""Try(so.get + "m"): ${Try(so.get + "m")} vs $modified""")
    println()

    // let's write a wrapper for that

    val wrap = new ResultWrapper(res)
    val s1: Try[Option[String]] = wrap.getStringOpt1("int")
    println(s"""wrap.getStringOpt1("int"): $s1""")
    val s2: Try[Option[String]] = wrap.getStringOpt2("int")
    println(s"""wrap.getStringOpt2("int"): $s2""")
  }
}
