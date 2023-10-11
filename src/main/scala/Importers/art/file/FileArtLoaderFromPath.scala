package Importers.art.file

import asciiArtApp.models.arts.RgbArt
import asciiArtApp.models.pixels.RgbPixel

import java.awt.Color
import java.io.{File, IOException}
import javax.imageio.ImageIO

class FileArtLoaderFromPath(pathToFile: String) extends FileArtLoader[RgbArt] {
  /**
   * Loads item
   *
   * @return Loaded item
   */
  override def load(): RgbArt = {
    if (pathToFile == null)
      throw new IllegalArgumentException("Path to file is null.")
    try {
      val bufferImage = ImageIO.read(new File(pathToFile))
      var grid = Seq[Seq[RgbPixel]]()

      for (i <- 0 until bufferImage.getHeight()) {
        var raw = Seq[RgbPixel]()
        for (j <- 0 until bufferImage.getWidth()) {
          val color = new Color(bufferImage.getRGB(j, i))
          val red = color.getRed
          val green = color.getGreen
          val blue = color.getBlue
          raw = raw.appended(RgbPixel(red, green, blue))
        }
        grid = grid.appended(raw)
      }

      RgbArt(grid)
    } catch {
      case e: IOException => throw new IllegalArgumentException("Can't import non-existent file.")
    }
  }
}
