import com.coding.exersises.Fragment
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec

class fragmentSpec extends AnyWordSpec with Matchers {

      "translate hex to base 10" in {
        Fragment.extractSegmentFromBinaryToInt(0x781002, 1, 32) shouldBe 7868418
      }

      "create new fragment from Hex Int" in {
        val x: Int = 0x781002
        Fragment(x).matchTime shouldBe 15
        Fragment(x).pointsScored shouldBe 2
        Fragment(x).team1PointsTotal shouldBe 2
        Fragment(x).team2PointsTotal shouldBe 0
        Fragment(x).whoScored shouldBe 0
      }

      //potential validations
      // max pointsScored should limit from 1-3 (think basketball)
      // points scored should equal diff of player scores from previous fragment
      // who scored - should validate with team who points changed
      // pointsScored + total + matchtime should always increase
      // verify that sendFragment is called

}
