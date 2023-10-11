package asciiArtApp.console.views.handling.correctors

import asciiArtApp.console.controllers.Controller
import correctors.art.specific.RotateArtCorrector

class RegExpRotateHandler(controller: Controller) extends RegExpCorrectHandler("--rotate\\s*(\\S*)".r) {
  override def commandName: String = "--rotate"

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
    for (deg <- args) {
      try {
        val degree: Int = deg.toInt
        controller.applyCorrector(new RotateArtCorrector(degree))
      } catch {
        case e: NumberFormatException => throw new IllegalArgumentException("The rotation degree must be a positive number.")
      }
    }
  }
}
