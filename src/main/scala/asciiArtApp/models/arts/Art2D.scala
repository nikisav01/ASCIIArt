package asciiArtApp.models.arts

import asciiArtApp.models.pixels.Pixel

abstract class Art2D[T <: Pixel](protected val grid: Seq[Seq[T]]) extends Art{
  /**
   * Get Art pixel at coordinates (x, y)
   *
   * @param x X coordinate
   * @param y Y coordinate
   * @return
   */
  def getPixel(x: Int, y: Int): T = grid(x)(y)

  /**
   * Get raw of the art
   * @param x Number of raw from 0
   * @return
   */
  def getRaw(x: Int): Seq[T] = grid(x)

  /**
   * Get read only grid of the art
   * @return
   */
  def getGrid: Seq[Seq[T]] = grid

  /**
   * Height of the Art
   *
   * @return
   */
  def height: Int = grid.length

  /**
   * Width of the Art
   *
   * @return
   */
  def width: Int = {
    if (grid.isEmpty)
      0
    else
      grid.head.length
  }
}
