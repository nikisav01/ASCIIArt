package correctors.art.defaults

import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.pixels.GreyPixel
import correctors.defaults.IdentityCorrector
import org.scalatest.FunSuite

import scala.util.Random

class IdentityArt2DCorrectorTest extends FunSuite {
  test("Identity corrector GreyArt") {
    val corrector = new IdentityArt2DCorrector

    val art = GreyArt(Seq(
      Seq(GreyPixel(10), GreyPixel(20)),
      Seq(GreyPixel(30), GreyPixel(40)),
      Seq(GreyPixel(50), GreyPixel(60))
    ))
    val corrected = corrector.correct(art)

    for (i <- art.getGrid.indices) {
      for (j <- art.getRaw(i).indices) {
        assert(art.getPixel(i, j).greyVal == corrected.getPixel(i, j).greyVal)
      }
    }
  }
}
