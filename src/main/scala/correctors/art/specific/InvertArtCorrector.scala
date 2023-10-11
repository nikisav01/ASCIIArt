package correctors.art.specific

import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.pixels.GreyPixel
import correctors.art.ArtCorrector

class InvertArtCorrector extends ArtCorrector {
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
        raw = raw.appended(GreyPixel(255 - item.getPixel(i, j).greyVal))
      }
      grid = grid.appended(raw)
    }

    GreyArt(grid)
  }
}
