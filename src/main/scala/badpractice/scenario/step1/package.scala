package badpractice.scenario

import badpractice.scenario.step1.PropertyValue

import scala.language.implicitConversions

package object step1 {
  implicit def asPropertyValue(value: Any): PropertyValue = PropertyValue(value)
}
