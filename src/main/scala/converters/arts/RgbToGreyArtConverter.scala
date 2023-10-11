package converters.arts

import asciiArtApp.models.arts.{GreyArt, RgbArt}
import asciiArtApp.models.pixels.{GreyPixel, RgbPixel}

class RgbToGreyArtConverter extends ArtConverter[RgbArt, GreyArt] {
  /**
   * Converts the item with type T to type R
   *
   * @param item The item to convert
   * @return
   */
  override def convert(item: RgbArt): GreyArt = {
    var grid = Seq[Seq[GreyPixel]]()

    for (i <- item.getGrid.indices) {
      var raw = Seq[GreyPixel]()
      for (j <- item.getRaw(i).indices) {
        val rgbPixel = item.getPixel(i, j)
        raw = raw.appended(GreyPixel(calculateGreyValue(rgbPixel)))
      }
      grid = grid.appended(raw)
    }

    GreyArt(grid)
  }

  protected def calculateGreyValue(pixel: RgbPixel): Int = {
    ((0.3 * pixel.red) + (0.59 * pixel.green) + (0.11 * pixel.blue)).toInt
  }
}
