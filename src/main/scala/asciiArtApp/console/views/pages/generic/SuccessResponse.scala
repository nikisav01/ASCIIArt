package asciiArtApp.console.views.pages.generic

import asciiArtApp.console.views.pages.TextPage

class SuccessResponse extends TextPage{
  /**
   * Renders the content of the page in a datatype T
   *
   * @return
   */
  override def render(): String = "Success.\n"
}
