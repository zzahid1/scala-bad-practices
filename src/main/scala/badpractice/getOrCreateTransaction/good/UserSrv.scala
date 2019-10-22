package badpractice.getOrCreateTransaction.good

import badpractice.getOrCreateTransaction.shared.{User, UserIndexer}

import scala.util.Try

class UserSrv(userRepo: UserRepo,
              userIndexer: UserIndexer,
              txMgr: TxManager) {
  def saveUser(user: User): Try[Unit] = for {
    _ <- txMgr.transactionally { implicit tx =>
      userRepo.saveUser(user)
    }
    // should be after the transaction because it select data
    _ <- userIndexer.index(user)
  } yield ()
}
