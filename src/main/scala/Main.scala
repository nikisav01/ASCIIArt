import asciiArtApp.console.controllers.{ConsoleController, Controller}
import asciiArtApp.console.views.rendering.ConsoleView

/**
 * Example:
 * --image "images/img.png" --invert --output-console --brightness 30 --output-file "outputs/art1.txt" --table "bourke"
 */

object Main extends App {
  val controller: Controller = new ConsoleController
  val view: ConsoleView = new ConsoleView(controller)

  view.run()
}
