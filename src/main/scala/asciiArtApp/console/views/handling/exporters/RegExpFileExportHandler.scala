package asciiArtApp.console.views.handling.exporters

import asciiArtApp.console.controllers.Controller

import java.io.File

class RegExpFileExportHandler(controller: Controller) extends RegExpExportHandler("--output-file\\s*\"(\\S*)\"".r) {
  override def commandName: String = "--output-file"

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
    for (path <- args) {
      controller.convertImageToFile(path)
    }
  }
}
