package badpractice.getOrCreateTransaction.good

import badpractice.getOrCreateTransaction.shared.{User, UserIndexer}

import scala.util.Try

class UserSrv(userRepo: UserRepo,
              userIndexer: UserIndexer,
              txMgr: TxManager) {
  def save(u: User): Try[Unit] = for {
    _ <- txMgr.begin { implicit tx =>
      userRepo.save(u)
    }
    // should be after the transaction
    _ <- userIndexer.index(u)
  } yield ()
}
