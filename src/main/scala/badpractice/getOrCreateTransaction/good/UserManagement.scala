package badpractice.getOrCreateTransaction.good

import badpractice.getOrCreateTransaction.shared.User

import scala.util.Try

class UserManagement(userSrv: UserSrv,
                     statRepo: StatRepo,
                     txMgr: TxManager) {
  def saveUser(u: User): Try[Unit] =
    txMgr.begin { implicit tx =>
      for {
        _ <- userSrv.saveUser(u)
        _ <- statRepo.userSaved()
      } yield ()
    }
}
