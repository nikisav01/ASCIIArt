package generators.art
import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.pixels.GreyPixel

import scala.util.Random

class RandomGreyArtGenerator extends ArtGenerator[GreyArt] {
  /**
   * Generates a random GreyArt
   * @return Generated art
   */
  override def generate(): GreyArt = {
    val rand = new Random
    val height = rand.between(50, 600)
    val width = rand.between(50, 600)
    var grid = Seq[Seq[GreyPixel]]()

    for (i <- 0 until height) {
      var raw = Seq[GreyPixel]()
      for (j <- 0 until width) {
        raw = raw.appended(GreyPixel(rand.nextInt(255)))
      }
      grid = grid.appended(raw)
    }

    GreyArt(grid)
  }
}
