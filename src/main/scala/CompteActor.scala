

object Compte{
  case class AjoutArgent(sld:Double)}

  class CompteActor(firstname:String) extends Actor {
    import Compte._
    var sldact:Double=200.0
    val log =Logging(context.system, this)

    def sum(x:Double,y:Double):Double=x+y

    override def receive: Receive = {
      case AjoutArgent(sld:Double) => sender ! sum(sld,sldact)}}

