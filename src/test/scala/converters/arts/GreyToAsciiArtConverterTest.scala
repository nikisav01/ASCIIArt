package converters.arts

import asciiArtApp.models.arts.{AsciiArt, GreyArt}
import asciiArtApp.models.pixels.{AsciiPixel, GreyPixel}
import asciiArtApp.models.tables.linear.BourkesTable
import org.scalatest.FunSuite

class GreyToAsciiArtConverterTest extends FunSuite {
  test("Convert correct Art") {
    val table = BourkesTable()
    val converter = new GreyToAsciiArtConverter(table)
    val art: GreyArt = GreyArt(Seq(
      Seq(GreyPixel(0), GreyPixel(30)),
      Seq(GreyPixel(75), GreyPixel(80)),
      Seq(GreyPixel(105), GreyPixel(150)),
      Seq(GreyPixel(170), GreyPixel(180)),
      Seq(GreyPixel(231), GreyPixel(255)),
    ))

    val reference: AsciiArt = AsciiArt(Seq(
      Seq(AsciiPixel('@'), AsciiPixel('%')),
      Seq(AsciiPixel('#'), AsciiPixel('*')),
      Seq(AsciiPixel('+'), AsciiPixel('=')),
      Seq(AsciiPixel('-'), AsciiPixel(':')),
      Seq(AsciiPixel(' '), AsciiPixel(' ')),
    ))
    val converted = converter.convert(art)

    for (r <- reference.getGrid.indices) {
      for (c <- reference.getRaw(r).indices) {
        assert(reference.getPixel(r, c).char == converted.getPixel(r, c).char)
      }
    }
  }
}
