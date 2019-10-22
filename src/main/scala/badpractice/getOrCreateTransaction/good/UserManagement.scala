package badpractice.getOrCreateTransaction.good

import badpractice.getOrCreateTransaction.shared.User

import scala.util.Try

class UserManagement(userSrv: UserSrv,
                     statRepo: StatRepo,
                     txMgr: TxManager) {
  def saveUser(user: User): Try[Unit] =
    txMgr.transactionally { implicit tx =>
      for {
        _ <- userSrv.saveUser(user)
        _ <- statRepo.userSaved()
      } yield ()
    }
}