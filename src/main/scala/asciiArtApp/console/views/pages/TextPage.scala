package asciiArtApp.console.views.pages

trait TextPage extends Page[String] {

  /**
   * Renders the content of the page in a datatype T
   * @return
   */
  def render(): String

}
