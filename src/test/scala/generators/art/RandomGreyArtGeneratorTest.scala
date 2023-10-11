package generators.art

import org.scalatest.FunSuite

class RandomGreyArtGeneratorTest extends FunSuite {
  test("Generate 10 arts") {
    val generator = new RandomGreyArtGenerator
    for (i <- 0 until 10) {
      val art = generator.generate()
      assert(art.height <= 600 && art.height >= 50)
      assert(art.width <= 600 && art.width >= 50)
      for (r <- art.getGrid.indices) {
        for (p <- art.getRaw(r).indices) {
          assert(art.getPixel(r, p).greyVal >= 0 && art.getPixel(r, p).greyVal <= 255)
        }
      }
    }
  }
}
