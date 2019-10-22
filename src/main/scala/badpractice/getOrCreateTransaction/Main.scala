package badpractice.getOrCreateTransaction

import badpractice.getOrCreateTransaction.shared.{User, UserIndexer}

object Main {
  def main(args: Array[String]): Unit = {
  }

  def bad(): Unit = {
    import badpractice.getOrCreateTransaction.bad._
    val txMgr = new TxManager()
    val userRepo = new UserRepo()
    val statRepo = new StatRepo
    val userIndexer = new UserIndexer()
    val userSrv = new UserSrv(userRepo, userIndexer, txMgr)
    val userMgt = new UserManagement(userSrv, statRepo, txMgr)

    userSrv.saveUser(User(1, "Loïc"))

    userMgt.saveUser(User(1, "Loïc"))

  }

  def good(): Unit = {
    import badpractice.getOrCreateTransaction.good._
    val txMgr = new TxManager()
    val userRepo = new UserRepo()
    val statRepo = new StatRepo
    val userIndexer = new UserIndexer()
    val userSrv = new UserSrv(userRepo, userIndexer, txMgr)
    val userMgt = new UserManagement(userSrv, statRepo, txMgr)

    userSrv.saveUser(User(1, "Loïc"))

    userMgt.saveUser(User(1, "Loïc"))

  }
}
