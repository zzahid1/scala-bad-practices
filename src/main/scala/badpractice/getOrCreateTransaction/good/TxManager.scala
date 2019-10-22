package badpractice.getOrCreateTransaction.good

import badpractice.getOrCreateTransaction.shared.Tx

import scala.util.{Failure, Success, Try}

class TxManager {
  def transactionally[A](block: Tx => Try[A]): Try[A] = {
    val tx = new Tx()
    try {
      val result = block(tx) // execute code here
      result match {
        case Success(_) => tx.commit()
        case Failure(_) => tx.rollback()
      }
      result
    } catch {
      case e: Throwable =>
        tx.rollback()
        Failure(e)
    } finally {
      tx.close()
    }
  }
}
