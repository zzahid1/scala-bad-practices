package badpractice.getOrCreateTransaction.bad

import badpractice.getOrCreateTransaction.shared.{User, UserIndexer}

import scala.util.Try

class UserSrv(userRepo: UserRepo,
              userIndexer: UserIndexer,
              txMgr: TxManager) {
  def saveUser(u: User): Try[Unit] = for {
    _ <- txMgr.begin {
      userRepo.saveUser(u)
    }
    // should be after the transaction
    _ <- userIndexer.index(u)
  } yield ()
}
