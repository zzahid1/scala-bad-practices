package badpractice.getOrCreateTransaction.bad

import badpractice.getOrCreateTransaction.shared.Tx

import scala.util.{Failure, Success, Try}

class TxManager {
  private val currentTx = new ThreadLocal[Tx]()

  def transactionally[A](block: => Try[A]): Try[A] = {
    if (currentTx.get() == null) {
      val tx = new Tx()
      try {
        currentTx.set(tx)
        val result = block // execute code here
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
        currentTx.remove()
      }
    } else {
      block // already inside transaction, execute code
    }
  }
}
