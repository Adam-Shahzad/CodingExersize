import com.coding.exersises.Fragment.isValid
import com.coding.exersises.{Fragment, Main, SenderService, SenderServiceClient}
import org.mockito.ArgumentMatchers.any
import org.mockito.{Mock, Mockito}
import org.mockito.Mockito.verify
import org.mockito.MockitoSugar.mock
import org.scalatest.Outcome
import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.FixtureAnyWordSpec

class flowSpec extends FixtureAnyWordSpec with Matchers{

  "Consume valid data and send via sender Service" in { f =>
    import f._
      Main().run(List(0x781002))
      verify(mockSenderService).sendFragmentInfo(Fragment(any))
  }

  "Consume invalid data and not send via sender Service" in { f =>
    import f._
    Main().run(List(0))
    verify(mockSenderService, Mockito.times(0))
      .sendFragmentInfo(Fragment(0x781002))
  }


  "Consume both valid invalid data and act acordingly" in { f =>
    import f._
    Main().run(List(0x781002, 0))
    verify(mockSenderService, Mockito.times(1))
      .sendFragmentInfo(any)
  }


    override protected def withFixture(test:  OneArgTest): Outcome = {
      val mockSenderService = mock[SenderServiceClient]
      super.withFixture(test.toNoArgTest(FixtureParam(mockSenderService)))
    }
  case class FixtureParam(mockSenderService: SenderService)
}
