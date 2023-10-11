package correctors.art.mixed

import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.pixels.GreyPixel
import correctors.art.specific.{BrightArtCorrector, InvertArtCorrector, RotateArtCorrector}
import org.scalatest.FunSuite

class MixedCorrectorTest extends FunSuite {
  private val art = GreyArt(Seq(
    Seq(GreyPixel(10), GreyPixel(20)),
    Seq(GreyPixel(30), GreyPixel(40)),
    Seq(GreyPixel(50), GreyPixel(60))
  ))

  test("Invert, Rotate, Bright") {
    val corrector = new MixedCorrector(Seq(new InvertArtCorrector, new RotateArtCorrector(90), new BrightArtCorrector(-30)))
    val corrected = corrector.correct(art)

    val reference = GreyArt(Seq(
      Seq(GreyPixel(175), GreyPixel(195), GreyPixel(215)),
      Seq(GreyPixel(165), GreyPixel(185), GreyPixel(205))
    ))
    for (i <- reference.getGrid.indices) {
      for (j <- reference.getRaw(i).indices) {
        assert(reference.getPixel(i, j).greyVal == corrected.getPixel(i, j).greyVal)
      }
    }
  }
}
