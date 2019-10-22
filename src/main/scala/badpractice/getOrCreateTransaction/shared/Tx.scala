package badpractice.getOrCreateTransaction.shared

class Tx {
  def commit(): Unit = ()

  def rollback(): Unit = ()

  def close(): Unit = ()
}
