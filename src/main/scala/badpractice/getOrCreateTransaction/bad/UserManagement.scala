package badpractice.getOrCreateTransaction.bad

import badpractice.getOrCreateTransaction.shared.User

import scala.util.Try

class UserManagement(userSrv: UserSrv,
                     statRepo: StatRepo,
                     txMgr: TxManager) {
  def saveUser(user: User): Try[Unit] =
    txMgr.transactionally {
      for {
        _ <- userSrv.saveUser(user)
        _ <- statRepo.userSaved()
      } yield ()
    }
}
