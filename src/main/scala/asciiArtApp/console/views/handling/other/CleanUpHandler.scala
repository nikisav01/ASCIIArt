package asciiArtApp.console.views.handling.other

import asciiArtApp.console.controllers.Controller
import asciiArtApp.console.views.handling.CommandHandler
import responsibilityChain.Handler

class CleanUpHandler(controller: Controller) extends CommandHandler {

  override def handle(item: String): Option[Handler[String]] = {
    controller.cleanUp()
    nextHandler
  }

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
  }

  /**
   * Name of the command
   *
   * @return
   */
  override def commandName: String = "clean"
}
