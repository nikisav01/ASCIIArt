package asciiArtApp.console.views.handling.loaders

import asciiArtApp.console.controllers.Controller

class RegExpFileLoadHandler(controller: Controller) extends RegExpLoadHandler("--image\\s*\"(\\S*)\"".r) {

  override def commandName: String = "--image"

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
    if (args.length != 1)
      throw new IllegalArgumentException("You can convert only one image.")

    controller.loadFromFile(args.head)
  }
}
