package asciiArtApp.console.views.handling.other

import asciiArtApp.console.views.handling.CommandHandler
import responsibilityChain.Handler

/**
 * Class required for input validation
 */
class InputValidationHandler extends CommandHandler {

  override def handle(item: String): Option[Handler[String]] = {
    val regExpImage = "--image\\s*\"(\\S*)\"".r
    val imageMatch = regExpImage.findAllIn(item)

    if (imageMatch.isEmpty && !item.contains("--image-random"))
      throw new IllegalArgumentException("Command must have one image source. Try \"--image \"path\\image.png\"\" or \"--image-random\".")
    else if (imageMatch.nonEmpty && item.contains("--image-random"))
      throw new IllegalArgumentException("Command must have one image source.")
    else if (imageMatch.length > 1)
      throw new IllegalArgumentException("Command must have one image source.")

    if (!item.contains("--output-console") && !item.contains("--output-file"))
      throw new IllegalArgumentException("Command must have at least one output. Try \"--output-console\" or \"--output-file \"path\"\".")

    val regExpTable = "-table".r
    val tableMatch = regExpTable.findAllIn(item)

    if (tableMatch.length > 1)
      throw new IllegalArgumentException("Command can't contain more than one tables.")

    nextHandler
  }

  /**
   * Processes already parsed command with arguments
   *
   * @param args Arguments to process (matching the regexp)
   */
  override protected def processCommand(args: Seq[String]): Unit = {}

  /**
   * Name of the command
   *
   * @return
   */
  override def commandName: String = "validation"
}
