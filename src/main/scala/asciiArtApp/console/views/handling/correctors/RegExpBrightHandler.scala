package asciiArtApp.console.views.handling.correctors

import asciiArtApp.console.controllers.Controller
import correctors.art.specific.BrightArtCorrector

class RegExpBrightHandler(controller: Controller) extends RegExpCorrectHandler("--brightness\\s*(\\S*)".r) {
  override def commandName: String = "--brightness"

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
    for (br <- args) {
      try {
        val brightness: Int = br.toInt
        controller.applyCorrector(new BrightArtCorrector(brightness))
      } catch {
        case e: NumberFormatException => throw new IllegalArgumentException("The brightness must be a number.")
      }
    }
  }
}
