
import akka.actor.{ActorSystem, Props}
import akka.testkit.{TestKit, TestProbe}
import org.scalatest.{BeforeAndAfterAll, FlatSpecLike, MustMatchers}

class CompteSpec extends TestKit(ActorSystem("test-system"))
  with FlatSpecLike
  with BeforeAndAfterAll
  with MustMatchers{

  override def afterAll()= TestKit.shutdownActorSystem(system)



  "Compte Actor"  should "handle add amount account message with TestProbe" in{

    val sender=TestProbe()
    val compte=system.actorOf(Props[CompteActor])
    sender.send(compte,Compte.AjoutArgent(500.0))
    val state=sender.expectMsgType[Double]
    state must equal (700.0)


  }


}
