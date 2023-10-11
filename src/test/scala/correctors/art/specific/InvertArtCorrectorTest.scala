package correctors.art.specific

import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.pixels.GreyPixel
import org.scalatest.FunSuite

import scala.util.Random

class InvertArtCorrectorTest extends FunSuite {
  test("Random Inverting") {
    val corrector = new InvertArtCorrector
    for (i <- 0 until 10) {
      val rand = Random
      val art = GreyArt(Seq(
        Seq(GreyPixel(rand.nextInt(255)), GreyPixel(rand.nextInt(255))),
        Seq(GreyPixel(rand.nextInt(255)), GreyPixel(rand.nextInt(255))),
        Seq(GreyPixel(rand.nextInt(255)), GreyPixel(rand.nextInt(255)))
      ))
      val corrected = corrector.correct(art)
      for (r <- corrected.getGrid.indices) {
        for (c <- corrected.getRaw(r).indices) {
          assert(255 - art.getPixel(r, c).greyVal == corrected.getPixel(r, c).greyVal)
        }
      }
    }
  }
}
