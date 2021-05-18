package com.coding.exersises
import scala.concurrent.Future

trait SenderService {
   def sendFragmentInfo(fragment: Fragment): Future[Unit]
}

class SenderServiceClient extends SenderService {
    override def sendFragmentInfo(fragment:  Fragment): Future[Unit] =
      Future.successful()
}

object SenderServiceClient {
  def apply = new SenderServiceClient
}
