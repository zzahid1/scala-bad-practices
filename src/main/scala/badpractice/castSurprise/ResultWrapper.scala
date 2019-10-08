package badpractice.castSurprise

import scala.util.Try

class ResultWrapper(underlying: Result) {
  def getStringOpt1(name: String): Try[Option[String]] = Try(Option(underlying.getProperty[String](name)))

  def getStringOpt2(name: String): Try[Option[String]] = Try(Option(underlying.getProperty[String](name)).map(_.toString))

  def getIntOpt1(name: String): Try[Option[Int]] = Try(Option(underlying.getProperty[Int](name)))

  def getIntOpt2(name: String): Try[Option[Int]] = Try(Option(underlying.getProperty[Int](name)).map(_.toInt))
}
