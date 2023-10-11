package asciiArtApp.console.views.handling.exporters

import asciiArtApp.console.controllers.Controller

class RegExpConsoleExportHandler(controller: Controller) extends RegExpExportHandler("(--output-console)".r) {
  override def commandName: String = "--output-console"

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
    if (args.nonEmpty)
      controller.convertImageToConsole()
  }
}
