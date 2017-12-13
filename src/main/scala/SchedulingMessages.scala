

object SchedulingMessages extends App  {

  val system = ActorSystem("Scheduling-Messages")

  val scheduler = system.actorOf(Props[ScheduleInReceive], "schedule-in-receive")
  Thread.sleep(5000)
  system.terminate()

}
