package asciiArtApp.console.views.handling.loaders

import asciiArtApp.console.controllers.Controller

class RegExpRandomLoadHandler(controller: Controller) extends RegExpLoadHandler("(--image-random)".r) {
  override def commandName: String = "--image-random"

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
    controller.loadRandomArt()
  }
}
