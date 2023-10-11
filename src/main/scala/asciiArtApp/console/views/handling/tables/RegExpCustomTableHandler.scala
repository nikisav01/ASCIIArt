package asciiArtApp.console.views.handling.tables

import asciiArtApp.console.controllers.Controller
import asciiArtApp.console.views.handling.RegExpCommandHandler
import asciiArtApp.models.tables.linear.CustomLinearTable

class RegExpCustomTableHandler(controller: Controller) extends RegExpCommandHandler("--custom-table\\s*\"(\\S*)\"".r) {
  override def commandName: String = "--custom-table"

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
    if (args.head.isEmpty)
      throw new IllegalArgumentException("Table can't be empty.")

    controller.setTable(new CustomLinearTable(args.head))
  }
}
