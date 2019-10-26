package badpractice.getOrCreateTransaction.good

import badpractice.getOrCreateTransaction.shared.Tx

import scala.util.{Failure, Try}

class TxManager {
  def begin[A](f: Tx => Try[A]): Try[A] = {
    val tx = new Tx()
    try {
      val res = f(tx) // execute code
      res.fold(_ => tx.ko, _ => tx.ok)
      res
    } catch {
      case e: Throwable =>
        tx.ko
        Failure(e)
    } finally {
      tx.close()
    }
  }
}
