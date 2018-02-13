package io.rr.scala.core.implicits

object ImplicitParameter extends AnyRef with App {

  private val exec: Executor =
    ((task: Task) => scala.Predef.println(task.toString()))

  implicit def executor: Executor =
    ImplicitParameter.this.exec

  def run(task: Task)(implicit executor: Executor): Unit = executor.run(task)

  ImplicitParameter.this.run(
    {
      final class $anon extends AnyRef with Task {}
      new $anon()
    }
  )(ImplicitParameter.this.executor)
}

trait Task {
  override def toString = {
    "This is my task!"
  }
}

trait Executor {
  def run(task: Task)
}
