package asciiArtApp.console.views.handling

import responsibilityChain.{Handler, SimpleHandler}

trait CommandHandler extends SimpleHandler[String] {
  /**
   * Method handling the users input command
   * @param command The command
   * @return
   */
  def handle(command: String): Option[Handler[String]]

  /**
   * Processes already parsed command with arguments
   * @param args Arguments to process (matching the regexp)
   */
  protected def processCommand(args: Seq[String]): Unit

  /**
   * Name of the command
   * @return
   */
  def commandName: String
}
