package asciiArtApp.console.views.handling.other

import asciiArtApp.console.controllers.Controller
import asciiArtApp.console.views.handling.RegExpCommandHandler

class RegExpHelpHandler(controller: Controller) extends RegExpCommandHandler("(help)".r) {
  override def commandName: String = "help"

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
    controller.showHelp()
  }
}
