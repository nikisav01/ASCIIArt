package asciiArtApp.console.views.handling.tables

import asciiArtApp.console.controllers.Controller
import asciiArtApp.console.views.handling.RegExpCommandHandler
import asciiArtApp.models.tables.linear.BourkesTable
import asciiArtApp.models.tables.nonlinear.MyNonLinearTable

class RegExpTableHandler(controller: Controller) extends RegExpCommandHandler("--table\\s*\"(\\S*)\"".r) {
  override def commandName: String = "--table"

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
    if (args.head.isEmpty)
      throw new IllegalArgumentException("Table can't be empty.")

    if (args.head == "bourke")
      controller.setTable(BourkesTable())
    else if (args.head == "non-linear")
      controller.setTable(MyNonLinearTable())
    else
      throw new IllegalArgumentException("Unknown table name: " + args.head + ". Try \"bourke\" or \"non-linear\" instead.")
  }
}
