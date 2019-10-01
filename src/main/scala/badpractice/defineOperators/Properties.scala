package badpractice.defineOperators

case class Properties(fields: Map[Property.Name, Property.Value]) {
  def get[A](p: Property[A]): Option[A] =
    fields.get(p.name).map(p.wrapper.decode)
}

object Properties {
  def apply(fields: (Property.Name, Property.Value)*): Properties = new Properties(fields.toMap)
}

case class Property[A](name: Property.Name, wrapper: Property.Wrapper[A]) {
  def ->(value: A): (Property.Name, Property.Value) = (name, wrapper.encode(value))
}

object Property {
  def apply[A](name: String, wrapper: Wrapper[A]): Property[A] =
    new Property[A](Name(name), wrapper)

  case class Name(value: String)

  sealed trait Wrapper[A] {
    def encode(value: A): Value

    def decode(value: Value): A
  }

  case object StringWrapper extends Wrapper[String] {
    override def encode(value: String): Value = StringValue(value)

    override def decode(value: Value): String = value match {
      case StringValue(v) => v
      case _ => throw new Exception("Oops")
    }
  }

  case object IntWrapper extends Wrapper[Int] {
    override def encode(value: Int): Value = IntValue(value)

    override def decode(value: Value): Int = value match {
      case IntValue(v) => v
      case _ => throw new Exception("Oops")
    }
  }

  sealed trait Value

  case class StringValue(value: String) extends Value

  case class IntValue(value: Int) extends Value

}
