import akka.actor.{Actor, ActorRef, Props}
import scala.concurrent.duration._

class SimulationController extends Actor{
  import context.dispatcher //thread simulation is running on.

  val processes: Vector [ActorRef] =
  (1 to 5).map (id=>context.actorOf(HostProcess.props("P" + id), "P" + id)).toVector

  def receive = {
    case StartSimulation =>
      processes.foreach(_ ! SayHello("hello"))
      context.system.scheduler.scheduleOnce(2.seconds, self, EndSimulation)

    case EndSimulation =>
      println()
      processes.foreach(_ ! ReportResults)
      context.system.terminate()
  }
}

object SimulationController {
  def props = Props (new SimulationController)
}