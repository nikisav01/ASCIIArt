package asciiArtApp.models.arts

import asciiArtApp.models.pixels.GreyPixel

case class GreyArt(protected override val grid: Seq[Seq[GreyPixel]]) extends Art2D[GreyPixel](grid) {
}
