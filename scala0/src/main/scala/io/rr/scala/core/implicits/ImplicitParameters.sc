implicit val executor: Executor = (task: Task) => println(task.toString)

def run(task: Task)(implicit executor: Executor): Unit = executor.run(task)
run(new Task {})

trait Task {
  override def toString = {
    "This is my task!"
  }
}
trait Executor {
  def run(task: Task)
}

//is converted to
object ImplicitParameter extends AnyRef with App {

  private val executor: Executor =
    ((task: Task) => scala.Predef.println(task.toString()));

  implicit def execute: Executor =
    ImplicitParameter.this.executor

  def run(task: Task)(implicit executor: Executor): Unit = executor.run(task)

  ImplicitParameter.this.run(
    {
      final class $anon extends AnyRef with Task {}
      new $anon()
    }
  )(ImplicitParameter.this.executor)
}