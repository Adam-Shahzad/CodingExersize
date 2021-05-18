package com.coding.exersises
import scala.concurrent.Future

trait SenderService {
   def sendFragmentInfo(fragment: Fragment): Future[Unit]
}

private class SenderServiceClient extends SenderService {
    override def sendFragmentInfo(fragment:  Fragment): Future[Unit] = ???
}

object SenderServiceClient {
  def apply = new SenderServiceClient
}
