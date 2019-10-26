package badpractice.typeSystemAbuse

import scala.collection.mutable

// cf CommentThreadOdbRepository.author
object DumbValues {

  case class User(id: String,
                  name: String,
                  rights: Seq[String])

  case class Comment(id: String,
                     text: String,
                     author: User)

  def build(id: String, text: String, user: String): Comment =
    Comment(
      id = id,
      text = text,
      author = User(
        id = "",
        name = user,
        rights = Seq()))

  val db: mutable.Map[String, User] = mutable.Map[String, User]()

  def delete(u: User): Unit = db.remove(u.id)

  delete(User("123", "", Seq()))

}
