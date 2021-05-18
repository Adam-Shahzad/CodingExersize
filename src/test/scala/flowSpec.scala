import akka.stream.impl.io.InputStreamSinkStage.Data
import com.coding.exersises.{Fragment, Main, SenderService}
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.scalatest.Outcome
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.FixtureAnyWordSpec

class flowSpec extends FixtureAnyWordSpec with Matchers{

  "Consume data and send via sender Service" in { f =>
  import f._
    Main().run(List(0x781002))
    verify(mockSenderService).sendFragmentInfo(Fragment(0x781002))
  }


    override protected def withFixture(test:  OneArgTest): Outcome = {
      val mockSenderService = Mock[SenderService]
      super.withFixture(test.toNoArgTest(FixtureParam(mockSenderService)))
    }
  case class FixtureParam(mockSenderService: SenderService)
}
