package badpractice.getOrCreateTransaction.shared

class Tx {
  def ok: Unit = ()

  def ko: Unit = ()

  def close(): Unit = ()
}
