package com.coding.exersises
import scala.concurrent.Future

trait SenderService {
   def sendFragmentInfo(fragment: Fragment): Future[Unit]
}

case class SenderServiceClient() extends SenderService {
    override def sendFragmentInfo(fragment:  Fragment): Future[Unit] = Future.successful()
}

