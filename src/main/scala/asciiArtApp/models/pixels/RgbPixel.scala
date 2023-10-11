package asciiArtApp.models.pixels

/**
 * Case class that's representing rgb pixel.
 *
 * @param red   0 - 255
 * @param green 0 - 255
 * @param blue  0 - 255
 */
case class RgbPixel(red: Int, green: Int, blue: Int) extends Pixel {
}
