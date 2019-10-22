package badpractice.getOrCreateTransaction.good

import badpractice.getOrCreateTransaction.shared.{Tx, User}

import scala.util.{Success, Try}

class UserRepo {
  def saveUser(u: User)(implicit tx: Tx): Try[Unit] = Success(())
}
