package asciiArtApp.models.arts

import asciiArtApp.models.pixels.RgbPixel

case class RgbArt(protected override val grid: Seq[Seq[RgbPixel]]) extends Art2D[RgbPixel](grid) {
}
