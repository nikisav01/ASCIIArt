package asciiArtApp.console.views.pages.concrete

import asciiArtApp.console.views.pages.TextPage
import asciiArtApp.models.arts.AsciiArt

class AsciiArtPage(private val art: AsciiArt) extends TextPage {
  /**
   * Renders the AsciiArt
   *
   * @return
   */
  override def render(): String = {
    var content: String = ""

    for (r <- art.getGrid.indices) {
      for (c <- art.getRaw(r).indices) {
        content += art.getPixel(r, c).char
      }
      content += '\n'
    }

    content
  }
}
