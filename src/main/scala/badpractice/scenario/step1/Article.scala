package badpractice.scenario.step1

case class Article(id: String,
                   name: String,
                   properties: Map[String, PropertyValue])

case class Property(id: String,
                    name: String)

sealed trait PropertyValue

object PropertyValue {
  def apply(value: Any): PropertyValue = value match {
    case i: Int => IntValue(i)
    case s: String => StringValue(s)
    case _ => throw new IllegalArgumentException(s"Invalid PropertyValue($value)")
  }
}

case class IntValue(value: Int) extends PropertyValue

case class StringValue(value: String) extends PropertyValue
