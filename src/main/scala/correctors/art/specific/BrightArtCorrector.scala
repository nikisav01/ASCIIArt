package correctors.art.specific

import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.pixels.GreyPixel
import correctors.art.ArtCorrector

class BrightArtCorrector(value: Int) extends ArtCorrector {
  /**
   * Corrects an item
   *
   * @param item The item to correct
   * @return The corrected item
   */
  override def correct(item: GreyArt): GreyArt = {
    var grid = Seq[Seq[GreyPixel]]()

    for (i <- item.getGrid.indices) {
      var raw = Seq[GreyPixel]()
      for (j <- item.getRaw(i).indices) {
        val greyVal = item.getPixel(i, j).greyVal

        if (greyVal + value > 255)
          raw = raw.appended(GreyPixel(255))
        else if (greyVal + value < 0)
          raw = raw.appended(GreyPixel(0))
        else
          raw = raw.appended(GreyPixel(greyVal + value))
      }
      grid = grid.appended(raw)
    }

    GreyArt(grid)
  }
}
