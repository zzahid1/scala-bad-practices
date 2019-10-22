package badpractice.getOrCreateTransaction.bad

import scala.util.{Success, Try}

class StatRepo {
  // fails if no transaction
  def userSaved(): Try[Unit] = Success(())
}
