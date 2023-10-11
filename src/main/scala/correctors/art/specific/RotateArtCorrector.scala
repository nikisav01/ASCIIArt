package correctors.art.specific

import asciiArtApp.models.arts.GreyArt
import asciiArtApp.models.pixels.GreyPixel
import correctors.art.ArtCorrector

class RotateArtCorrector(degree: Int) extends ArtCorrector {
  /**
   * Corrector that corrects an image by degree
   *
   * @param item The item to correct
   * @return The corrected item
   */
  override def correct(item: GreyArt): GreyArt = {
    if (degree % 90 != 0)
      throw new IllegalArgumentException("Rotation degree must be divisible by 90.")

    val deg = degree % 360

    if (deg == 90 || deg == -270)
      rotateToRight(item)
    else if (deg == 180 || deg == -180)
      rotateToRight(rotateToRight(item))
    else if (deg == 270 || deg == -90)
      rotateToLeft(item)
    else
      item
  }

  protected def rotateToRight(item: GreyArt): GreyArt = {
    // Example:
    // [1 2]      [5 3 1]
    // [3 4]  =>  [6 4 2]
    // [5 6]
    val gridTmp = item.getGrid.transpose
    var grid = Seq[Seq[GreyPixel]]()

    for (i <- gridTmp.indices) {
      grid = grid.appended(gridTmp(i).reverse)
    }

    GreyArt(grid)
  }

  protected def rotateToLeft(item: GreyArt): GreyArt = {
    // Example:
    // [1 2]      [5 3 1]
    // [3 4]  =>  [6 4 2]
    // [5 6]
    var gridTmp = Seq[Seq[GreyPixel]]()

    for (i <- item.getGrid.indices) {
      gridTmp = gridTmp.appended(item.getRaw(i).reverse)
    }
    GreyArt(gridTmp.transpose)
  }
}
