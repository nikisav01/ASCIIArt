package converters.arts

import asciiArtApp.models.arts.{AsciiArt, GreyArt}
import asciiArtApp.models.pixels.AsciiPixel
import asciiArtApp.models.tables.Table

class GreyToAsciiArtConverter(table: Table[Int, Char]) extends ArtConverter[GreyArt, AsciiArt] {
  /**
   * Converts the item with type T to type R
   *
   * @param item The item to convert
   * @return
   */
  override def convert(item: GreyArt): AsciiArt = {
    var grid = Seq[Seq[AsciiPixel]]()

    for (i <- item.getGrid.indices) {
      var raw = Seq[AsciiPixel]()
      for (j <- item.getRaw(i).indices) {
        val greyVal = item.getPixel(i, j).greyVal
        raw = raw.appended(AsciiPixel(table.convert(greyVal)))
      }
      grid = grid.appended(raw)
    }

    AsciiArt(grid)
  }
}
