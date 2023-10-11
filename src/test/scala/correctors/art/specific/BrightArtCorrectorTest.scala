package correctors.art.specific

import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.pixels.GreyPixel
import org.scalatest.FunSuite

import scala.util.Random

class BrightArtCorrectorTest extends FunSuite {
  private val rand = Random
  private val art = GreyArt(Seq(
    Seq(GreyPixel(rand.between(20, 235)), GreyPixel(rand.between(20, 235))),
    Seq(GreyPixel(rand.between(20, 235)), GreyPixel(rand.between(20, 235))),
    Seq(GreyPixel(rand.between(20, 235)), GreyPixel(rand.between(20, 235)))
  ))

  test("Increase brightness < 255") {
    val corrector = new BrightArtCorrector(19)
    val corrected = corrector.correct(art)
    for (r <- corrected.getGrid.indices) {
      for (c <- corrected.getRaw(r).indices) {
        assert(art.getPixel(r, c).greyVal + 19 == corrected.getPixel(r, c).greyVal)
      }
    }
  }

  test("Increase brightness to 255") {
    val corrector = new BrightArtCorrector(255)
    val corrected = corrector.correct(art)
    for (r <- corrected.getGrid.indices) {
      for (c <- corrected.getRaw(r).indices) {
        assert(255 == corrected.getPixel(r, c).greyVal)
      }
    }
  }

  test("Decrease brightness > 0") {
    val corrector = new BrightArtCorrector(-19)
    val corrected = corrector.correct(art)
    for (r <- corrected.getGrid.indices) {
      for (c <- corrected.getRaw(r).indices) {
        assert(art.getPixel(r, c).greyVal - 19 == corrected.getPixel(r, c).greyVal)
      }
    }
  }

  test("Decrease brightness to 0") {
    val corrector = new BrightArtCorrector(-255)
    val corrected = corrector.correct(art)
    for (r <- corrected.getGrid.indices) {
      for (c <- corrected.getRaw(r).indices) {
        assert(0 == corrected.getPixel(r, c).greyVal)
      }
    }
  }
}
