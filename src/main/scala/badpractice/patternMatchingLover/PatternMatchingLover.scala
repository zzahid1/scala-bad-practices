package badpractice.patternMatchingLover

import scala.util.{Failure, Success, Try}

object PatternMatchingLover {


  def method(): Option[User] = {
    Try(toString) match {
      case Success(id) => UserRepo.findBy(id) match {
        case Some(user) => UserRepo.update(user) match {
          case Some(user) => Some(user)
          case _ => None
        }
        case None => UserRepo.create(id) match {
          case Some(user) => Some(user)
          case None => None
        }
      }
      case Failure(_)
      => None
    }
  }

  def method(): Option[User] = {
    for {
      x <- Try(toString).toOption
      user <- UserRepo.findBy(x).fold(UserRepo.create(x))((u) => UserRepo.update(u))
    } yield user
  }

  case class User(id: String)

  object UserRepo {
    def findBy(id: String): Option[User] = ???

    def update(user: User): Option[User] = ???

    def create(id: String): Option[User] = ???

  }


}
