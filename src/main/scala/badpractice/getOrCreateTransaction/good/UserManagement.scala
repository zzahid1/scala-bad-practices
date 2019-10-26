package badpractice.getOrCreateTransaction.good

import badpractice.getOrCreateTransaction.shared.User

import scala.util.Try

class UserManagement(userSrv: UserSrv,
                     statRepo: StatRepo,
                     txMgr: TxManager) {
  def save(u: User): Try[Unit] =
    txMgr.begin { implicit tx =>
      for {
        _ <- userSrv.save(u)
        _ <- statRepo.userSaved()
      } yield ()
    }
}
