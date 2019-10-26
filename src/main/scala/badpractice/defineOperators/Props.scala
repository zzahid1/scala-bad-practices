package badpractice.defineOperators

case class Props(in: Map[Prop.Name, Prop.Value]) {
  def get[A](p: Prop[A]): Option[A] =
    in.get(p.name).map(p.wrapper.decode)
}

object Props {
  def apply(in: (Prop.Name, Prop.Value)*): Props =
    new Props(in.toMap)
}

case class Prop[A](name: Prop.Name, wrapper: Prop.Wrap[A]) {
  def ->(value: A): (Prop.Name, Prop.Value) =
    (name, wrapper.encode(value))
}

object Prop {
  def apply[A](name: String, wrap: Wrap[A]): Prop[A] =
    new Prop[A](Name(name), wrap)

  case class Name(value: String)

  sealed trait Wrap[A] {
    def encode(value: A): Value

    def decode(value: Value): A
  }

  case object StrWrap extends Wrap[String] {
    override def encode(value: String): Value = StringValue(value)

    override def decode(value: Value): String = value match {
      case StringValue(v) => v
      case _ => throw new Exception("Oops")
    }
  }

  case object IntWrap extends Wrap[Int] {
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
