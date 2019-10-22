package badpractice.getOrCreateTransaction.shared

import scala.util.{Success, Try}

class UserIndexer {
  def index(user: User): Try[Unit] = Success(())
}
