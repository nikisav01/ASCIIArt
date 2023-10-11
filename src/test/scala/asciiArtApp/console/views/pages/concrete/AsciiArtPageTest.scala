package asciiArtApp.console.views.pages.concrete

import asciiArtApp.models.arts.AsciiArt
import asciiArtApp.models.pixels.AsciiPixel
import org.scalatest.FunSuite

class AsciiArtPageTest extends FunSuite {
  test("Ascii page") {
    val art: AsciiArt = AsciiArt(Seq(
      Seq(AsciiPixel('@'), AsciiPixel('%')),
      Seq(AsciiPixel('#'), AsciiPixel('*')),
      Seq(AsciiPixel('+'), AsciiPixel('=')),
      Seq(AsciiPixel('-'), AsciiPixel(':')),
      Seq(AsciiPixel(' '), AsciiPixel(' ')),
    ))
    val page = new AsciiArtPage(art)
    val reference: String = "@%\n#*\n+=\n-:\n  \n"
    assert(reference == page.render())
  }
}
