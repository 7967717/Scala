case class Email(
                  subject: String,
                  text: String,
                  sender: String,
                  recipient: String)
type EmailFilter = Email => Boolean
type IntPairPred = (Int, Int) => Boolean
def sizeConstraint(pred: IntPairPred, n: Int, email: Email): Boolean = pred(email.text.size, n)
val gt: IntPairPred = _ > _
val ge: IntPairPred = _ >= _
val lt: IntPairPred = _ < _
val le: IntPairPred = _ <= _
val eq: IntPairPred = _ == _
val minimumSize: (Int, Email) => Boolean = sizeConstraint(ge, _: Int, _: Email)
val maximumSize: (Int, Email) => Boolean = sizeConstraint(le, _: Int, _: Email)
val constr20: (IntPairPred, Email) => Boolean = sizeConstraint(_: IntPairPred, 20, _: Email)
val constr30: (IntPairPred, Email) => Boolean = sizeConstraint(_: IntPairPred, 30, _: Email)
//val min20: EmailFilter = minimumSize(20, _: Email)
//val max20: EmailFilter = maximumSize(20, _: Email)

def sizeConstraintCurr(pred: IntPairPred)(n: Int)(email: Email): Boolean =
  pred(email.text.size, n)
val sizeConstraintFn: IntPairPred => Int => Email => Boolean = sizeConstraintCurr
val minSize: Int => Email => Boolean = sizeConstraintCurr(ge)
val maxSize: Int => Email => Boolean = sizeConstraintCurr(le)
val min20: Email => Boolean = minSize(20)
val max20: Email => Boolean = maxSize(20)

val sum: (Int, Int) => Int = _ + _
val sumCurried: Int => Int => Int = sum.curried
sum(1, 1)
sumCurried(1)(1)


case class User(name: String)
trait EmailRepository {
  def getMails(user: User, unread: Boolean): Seq[Email]
}
trait FilterRepository {
  def getEmailFilter(user: User): EmailFilter
}
trait MailboxService {
  def getNewMails(emailRepo: EmailRepository)(filterRepo: FilterRepository)(user: User) =
    emailRepo.getMails(user, true).filter(filterRepo.getEmailFilter(user))
  val newMails: User => Seq[Email]
}

object MockEmailRepository extends EmailRepository {
  def getMails(user: User, unread: Boolean): Seq[Email] = Nil
}
object MockFilterRepository extends FilterRepository {
  def getEmailFilter(user: User): EmailFilter = _ => true
}
object MailboxServiceWithMockDeps extends MailboxService {
  val newMails: User => Seq[Email] =
    getNewMails(MockEmailRepository)(MockFilterRepository)
}

MailboxServiceWithMockDeps.newMails(User("daniel"))
