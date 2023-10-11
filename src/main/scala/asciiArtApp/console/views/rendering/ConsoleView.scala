package asciiArtApp.console.views.rendering

import asciiArtApp.console.controllers.Controller
import asciiArtApp.console.views.handling.CommandHandler
import asciiArtApp.console.views.handling.correctors.{RegExpBrightHandler, RegExpInvertHandler, RegExpRotateHandler}
import asciiArtApp.console.views.handling.exporters.{RegExpConsoleExportHandler, RegExpFileExportHandler}
import asciiArtApp.console.views.handling.loaders.{RegExpFileLoadHandler, RegExpRandomLoadHandler}
import asciiArtApp.console.views.handling.other.{CleanUpHandler, InputValidationHandler}
import asciiArtApp.console.views.handling.tables.{RegExpCustomTableHandler, RegExpTableHandler}
import responsibilityChain.Handler

import scala.io.StdIn

class ConsoleView(controller: Controller) {

  private var running = false
  private val commandHandler = commandHandlers(controller)

  def run(): Unit = {
    running = true

    while (running) {
      val command = StdIn.readLine()
      processCommand(command)
    }
  }

  def stop(): Unit = {
    running = false
  }

  def processCommand(command: String): Unit = {
    if (command == "stop" || command == "exit")
      stop()
    else if (command == "help")
      controller.showHelp()
    else {
      try {
        Handler.resolveAll(commandHandler, command)
      } catch {
        case e: Exception => controller.showError(e.getMessage)
      }
    }
  }

  protected def commandHandlers(controller: Controller): CommandHandler = {
    // input validation
    val inputValidationHandler = new InputValidationHandler

    // loaders
    val fileLoadHandler = new RegExpFileLoadHandler(controller)
    val randomLoadHandler = new RegExpRandomLoadHandler(controller)

    // correctors
    val rotateHandler = new RegExpRotateHandler(controller)
    val brightHandler = new RegExpBrightHandler(controller)
    val invertHandler = new RegExpInvertHandler(controller)

    // tables
    val tableHandler = new RegExpTableHandler(controller)
    val customTableHandler = new RegExpCustomTableHandler(controller)

    // exporters
    val consoleExportHandler = new RegExpConsoleExportHandler(controller)
    val fileExportHandler = new RegExpFileExportHandler(controller)

    // clean
    val cleanUpHandler = new CleanUpHandler(controller)

    val initialHandler: CommandHandler = inputValidationHandler
    initialHandler
      .setNext(fileLoadHandler)
      .setNext(randomLoadHandler)
      .setNext(rotateHandler)
      .setNext(brightHandler)
      .setNext(invertHandler)
      .setNext(tableHandler)
      .setNext(customTableHandler)
      .setNext(consoleExportHandler)
      .setNext(fileExportHandler)
      .setNext(cleanUpHandler)

    initialHandler
  }

}
