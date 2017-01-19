import akka.actor.ActorSystem

object DistributedSystem extends App {
  val system = ActorSystem("distributed-system")
  //creates actor within actor system

  val controller = system.actorOf(SimulationController.props, "simulation-controller")
  controller ! StartSimulation
}
