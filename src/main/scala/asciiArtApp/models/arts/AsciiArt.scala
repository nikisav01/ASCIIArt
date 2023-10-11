package asciiArtApp.models.arts

import asciiArtApp.models.pixels.AsciiPixel

case class AsciiArt(override protected val grid: Seq[Seq[AsciiPixel]]) extends Art2D[AsciiPixel](grid) {
}
