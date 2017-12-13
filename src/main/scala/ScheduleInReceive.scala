import java.util.Date

import scala.concurrent.duration._


class ScheduleInReceive extends Actor {

  override def preStart() =
    context.system.scheduler.scheduleOnce(500 millis, self, "tick")

  // override postRestart so we don't call preStart and schedule a new message
  override def postRestart(reason: Throwable) = {}

  def receive = {
    case "tick" =>
      println(s"Cool! I got tick message at ${new Date().toGMTString}")
      // send another periodic tick after the specified delay
      context.system.scheduler.scheduleOnce(1000 millis, self, "tick")

  }

}
