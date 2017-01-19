// Simulation control messages
case object StartSimulation

case object EndSimulation

// Simulation-application communication
case object ReportResults

// Network communication
case class SayHello (content: String)