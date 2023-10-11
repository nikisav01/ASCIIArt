package asciiArtApp.console.views.handling.correctors

import asciiArtApp.console.controllers.Controller
import asciiArtApp.console.views.handling.RegExpCommandHandler
import correctors.art.specific.InvertArtCorrector

class RegExpInvertHandler(controller: Controller) extends RegExpCommandHandler("(--invert)".r) {

  private val invertArtCorrector = new InvertArtCorrector

  override def commandName: String = "--invert"

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {
    for (_ <- args) {
      controller.applyCorrector(invertArtCorrector)
    }
  }
}
