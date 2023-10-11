package asciiArtApp.console.views.pages

trait Page[T] {

  /**
   * Renders the content of the page in a datatype T
   * @return
   */
  def render(): T

}
