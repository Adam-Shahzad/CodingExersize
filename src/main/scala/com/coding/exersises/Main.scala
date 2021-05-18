package com.coding.exersises
import akka.NotUsed
import akka.actor.{ActorSystem, Scheduler}
import akka.stream.scaladsl.{Flow, Sink, Source}
import com.coding.exersises.Fragment.isValid

import scala.concurrent.ExecutionContext

object Main extends App {
  implicit val system: ActorSystem = ActorSystem("Main")
  implicit val executionContext: ExecutionContext = system.dispatcher
  implicit val scheduler: Scheduler               = system.scheduler

  def source(input: List[Int]): Source[Int, NotUsed] = Source(input)

  private def eventFlow(): Flow[Int, Either[Error,Fragment], NotUsed] = Flow[Int].map{
    x =>
      if(isValid(Fragment(x))){
        SenderServiceClient.apply.sendFragmentInfo(Fragment(x))
        Right(Fragment(x))
      }
        Left(Error())
      }

  val sink = source(Data.badInput).via(eventFlow()).to(Sink.foreach(println(_)))
  sink.run()
}
