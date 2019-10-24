package badpractice.getOrCreateTransaction.good

import badpractice.getOrCreateTransaction.shared.Tx

import scala.util.{Failure, Success, Try}

class TxManager {
  def begin[A](block: Tx => Try[A]): Try[A] = {
    val tx = new Tx()
    try {
      val res = block(tx) // execute code
      res.fold(_ => tx.rollback(), _ => tx.commit())
      res
    } catch {
      case e: Throwable =>
        tx.rollback()
        Failure(e)
    } finally {
      tx.close()
    }
  }
}
