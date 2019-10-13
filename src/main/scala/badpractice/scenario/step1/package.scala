package badpractice.scenario

import scala.language.implicitConversions

package object step1 {
  implicit def asPropertyValue(value: Any): PropertyValue = PropertyValue(value)
}
