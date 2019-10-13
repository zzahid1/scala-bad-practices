package badpractice.scenario.step1

/**
 * Spec:
 *  - add dynamic properties to Article
 */
object App {
  def main(args: Array[String]): Unit = {
    val p: PropertyValue = 1
    val q: PropertyValue = true
    val r: PropertyValue = "toto"
  }
}
