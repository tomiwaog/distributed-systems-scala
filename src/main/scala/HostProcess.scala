import akka.actor.{Actor, Props}

class HostProcess (processID: String) extends Actor {
  def receive = {
    case SayHello (content) =>
      println(s"Someone said $content to me ($processID)")

    case ReportResults =>
      println(s"Everything seems to go well for me ($processID)")
  }
}

object HostProcess{
  def props (processID: String) = Props (new HostProcess (processID))
}
