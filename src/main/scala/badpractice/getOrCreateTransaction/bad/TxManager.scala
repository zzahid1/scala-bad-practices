package badpractice.getOrCreateTransaction.bad

import badpractice.getOrCreateTransaction.shared.Tx

import scala.util.{Failure, Try}

class TxManager {
  private val currentTx = new ThreadLocal[Tx]()

  def begin[A](f: => Try[A]): Try[A] = {
    if (currentTx.get() == null) {
      val tx = new Tx()
      try {
        currentTx.set(tx)
        val res = f // execute code
        res.fold(_ => tx.ko, _ => tx.ok)
        res
      } catch {
        case e: Throwable =>
          tx.ko
          Failure(e)
      } finally {
        tx.close()
        currentTx.remove()
      }
    } else {
      f // in transaction, execute code
    }
  }
}
