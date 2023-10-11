package asciiArtApp.models.arts

import asciiArtApp.models.pixels.{AsciiPixel, GreyPixel, RgbPixel}
import org.scalatest.FunSuite

import scala.util.Random

class Art2DTest extends FunSuite {
  test("AsciiArt") {
    val grid = Seq(
      Seq(AsciiPixel('@'), AsciiPixel('%')),
      Seq(AsciiPixel('#'), AsciiPixel('*')),
      Seq(AsciiPixel('+'), AsciiPixel('=')),
      Seq(AsciiPixel('-'), AsciiPixel(':')),
      Seq(AsciiPixel(' '), AsciiPixel(' ')),
    )
    val art: AsciiArt = AsciiArt(grid)
    assert(art.getGrid == grid)
    for (r <- art.getGrid.indices) {
      assert(art.getRaw(r) == grid(r))
      for (c <- art.getRaw(r).indices) {
        assert(art.getPixel(r, c).char == grid(r)(c).char)
      }
    }
    assert(art.height == 5)
    assert(art.width == 2)
  }

  test("GreyArt") {
    val grid = Seq(
      Seq(GreyPixel('@'), GreyPixel('%')),
      Seq(GreyPixel('#'), GreyPixel('*')),
      Seq(GreyPixel('+'), GreyPixel('=')),
      Seq(GreyPixel('-'), GreyPixel(':')),
      Seq(GreyPixel(' '), GreyPixel(' ')),
    )
    val art: GreyArt = GreyArt(grid)
    assert(art.getGrid == grid)
    for (r <- art.getGrid.indices) {
      assert(art.getRaw(r) == grid(r))
      for (c <- art.getRaw(r).indices) {
        assert(art.getPixel(r, c).greyVal == grid(r)(c).greyVal)
      }
    }
    assert(art.height == 5)
    assert(art.width == 2)
  }

  test("RgbArt") {
    val rand = Random
    val grid = Seq(
      Seq(RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))),
      Seq(RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))),
      Seq(RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))),
      Seq(RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255))),
      Seq(RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)), RgbPixel(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)))
    )
    val art: RgbArt = RgbArt(grid)

    assert(art.getGrid == grid)
    for (r <- art.getGrid.indices) {
      assert(art.getRaw(r) == grid(r))
      for (c <- art.getRaw(r).indices) {
        assert(art.getPixel(r, c).red == grid(r)(c).red)
        assert(art.getPixel(r, c).green == grid(r)(c).green)
        assert(art.getPixel(r, c).blue == grid(r)(c).blue)
      }
    }
    assert(art.height == 5)
    assert(art.width == 2)
  }
}
