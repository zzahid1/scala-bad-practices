package badpractice.getOrCreateTransaction.good

import badpractice.getOrCreateTransaction.shared.Tx

import scala.util.{Success, Try}

class StatRepo {
  def userSaved()(implicit tx: Tx): Try[Unit] = Success(())
}
