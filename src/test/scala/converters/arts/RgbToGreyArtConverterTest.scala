package converters.arts

import asciiArtApp.models.arts.RgbArt
import asciiArtApp.models.pixels.RgbPixel
import org.scalatest.FunSuite

import scala.util.Random

class RgbToGreyArtConverterTest extends FunSuite {
  private val rand = Random
  private val converter = new RgbToGreyArtConverter

  private def calculateGreyValue(pixel: RgbPixel): Int = {
    ((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)).toInt
  }

  test("Converting random") {
    for (i <- 0 until 10) {
      val art = RgbArt(Seq(
        Seq(RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))),
        Seq(RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))),
        Seq(RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))),
        Seq(RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))),
        Seq(RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)))
      ))
      val converted = converter.convert(art)
      for (r <- converted.getGrid.indices) {
        for (c <- converted.getRaw(r).indices) {
          assert(calculateGreyValue(art.getPixel(r, c)) == converted.getPixel(r, c).greyVal)
        }
      }
    }
  }
}
