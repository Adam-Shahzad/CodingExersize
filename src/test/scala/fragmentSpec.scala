import com.coding.exersises.Fragment
import com.coding.exersises.Fragment.isValid
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.wordspec.AnyWordSpec

class fragmentSpec extends AnyWordSpec with Matchers {

      "translate hex to base 10" in {
        Fragment.extractSegmentFromBinaryToInt(0x781002, 1, 32) shouldBe 7868418
      }

      "create new fragment from Hex Int 0x781002" in {
        val x: Int = 0x781002
        Fragment(x).matchTime shouldBe 15
        Fragment(x).pointsScored shouldBe 2
        Fragment(x).team1PointsTotal shouldBe 2
        Fragment(x).team2PointsTotal shouldBe 0
        Fragment(x).whoScored shouldBe 0
      }

      "create new fragment from Hex Int 0xf0101f" in {
        val x: Int = 0xf0101f
        Fragment(x).matchTime shouldBe 30
        Fragment(x).pointsScored shouldBe 3
        Fragment(x).team1PointsTotal shouldBe 2
        Fragment(x).team2PointsTotal shouldBe 3
        Fragment(x).whoScored shouldBe 1
      }

      "Fragment.isValid returns false if match time is 0" in {
        isValid(Fragment(0,1,1,1,1)).shouldBe(false)
      }

      "Fragment.isValid returns false if points scored is 0" in {
        isValid(Fragment(1,1,1,1,0)).shouldBe(false)
      }

      //potential validations
      // points scored should equal diff of player scores from previous fragment
      // who scored - should validate with team who points changed
      // pointsScored + total + matchtime should always increase
      // verify that sendFragment is called
      // verify that sendFragment is not called when fragment is bad

}
