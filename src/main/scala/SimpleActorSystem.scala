

object SimpleActorSystem extends App {

import m._

  class SimpleActor extends Actor {

    var count=0

    override def receive: Receive = {

      case message(m) => println("String " + m)
      case i: Int => println("Number " + i)
      case Increment => count+=1; self ! count

    }

  }

  val system = ActorSystem("SimpleSystem")
  val actor = system.actorOf(Props[SimpleActor], "SimpleActor")

  actor ! message("hello")
  actor ! 43
  actor ! Increment

  system.terminate()
}

object m{
  case class message(m:String)
  case object Increment
}