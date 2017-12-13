
import Compte.AjoutArgent

import scala.concurrent.Await
import scala.concurrent.duration._

object BanqueSystem  extends App {

  val system = ActorSystem("BanqueSystem")
  val compteactor = system.actorOf(Props(new CompteActor("Patrick")), name="CompteActor")
  implicit val timeout = Timeout(5 seconds)
  val future = compteactor ? AjoutArgent(500.0)
  val result = Await.result(future, timeout.duration)
  println(result)
  system.terminate()

}
