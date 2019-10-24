package badpractice.getOrCreateTransaction.bad

import badpractice.getOrCreateTransaction.shared.Tx

import scala.util.{Failure, Try}

class TxManager {
  private val currentTx = new ThreadLocal[Tx]()

  def begin[A](block: => Try[A]): Try[A] = {
    if (currentTx.get() == null) {
      val tx = new Tx()
      try {
        currentTx.set(tx)
        val res = block // execute code
        res.fold(_ => tx.rollback(), _ => tx.commit())
        res
      } catch {
        case e: Throwable =>
          tx.rollback()
          Failure(e)
      } finally {
        tx.close()
        currentTx.remove()
      }
    } else {
      block // in transaction, execute code
    }
  }
}
