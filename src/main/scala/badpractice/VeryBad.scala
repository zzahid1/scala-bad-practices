package badpractice

import java.time.Instant

import scala.util.Try

object VeryBad {

  class User() {
    def updatedAt(): Option[Instant] = null

    def validEmail(): Try[String] = throw new IllegalArgumentException("Email is invalid")
  }

}
